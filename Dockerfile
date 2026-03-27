# Etapa 1: Build
FROM amazoncorretto:17 AS build
WORKDIR /app

# Copiamos archivos de configuración primero para aprovechar el cache de Docker
COPY gradlew .
COPY gradle ./gradle
COPY build.gradle.kts settings.gradle.kts ./

# Descargar dependencias sin compilar todo el proyecto (ahorra tiempo en rediseños)
RUN chmod +x ./gradlew
RUN ./gradlew dependencies --no-daemon

# Copiar el código fuente de Kotlin y recursos
COPY src ./src

# Compilar solo el bootJar (el ejecutable de Spring) saltando los tests
RUN ./gradlew bootJar -x test --no-daemon

# Etapa 2: Runtime
FROM amazoncorretto:17-alpine
WORKDIR /app

# IMPORTANTE: Usamos un patrón más específico para evitar el error de múltiples JARs
# O simplemente apuntamos al nombre que Spring Boot genera por defecto
COPY --from=build /app/build/libs/*-SNAPSHOT.jar app.jar

ENV JAVA_OPTS="-Xms64m -Xmx450m -XX:+UseZGC -XX:MaxMetaspaceSize=128m -Xss512k"

# Usar ENTRYPOINT es mejor práctica para contenedores ejecutables
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]