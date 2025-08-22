# Etapa de construcción
FROM gradle:8.5-jdk17 AS build
WORKDIR /app

# Copiamos solo lo necesario primero (para cachear dependencias)
COPY gradlew .
COPY gradle ./gradle
RUN chmod +x gradlew

# Copiamos el resto del código
COPY . .

# Construimos el jar (sin tests para ahorrar tiempo)
RUN ./gradlew clean build -x test --stacktrace

# Etapa de runtime
FROM amazoncorretto:17-alpine
WORKDIR /app

# Copiamos el jar
COPY --from=build /app/build/libs/*.jar app.jar

# Variables JVM
ENV JAVA_OPTS="-Xms64m -Xmx450m -XX:+UseZGC -XX:MaxMetaspaceSize=128m -XX:CompressedClassSpaceSize=32m -XX:+HeapDumpOnOutOfMemoryError -XX:MaxGCPauseMillis=200 -XX:InitiatingHeapOccupancyPercent=35 -Xlog:gc*:file=gc.log:time,uptime,level,tags:filecount=5,filesize=10m -Xss512k"

# Ejecutamos la app
CMD ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
