# Start with a base image containing Java runtime (AdoptOpenJDK)
#FROM openjdk:17-jdk-slim AS build
FROM amazoncorretto:17 AS build

# Set the working directory in the image to "/app"
WORKDIR /app

# Instalar bash, git, unzip, curl
RUN yum install -y bash curl git unzip || true

# Copy the Gradle executable to the image
COPY gradlew ./

# Copy the 'gradle' folder to the image
COPY gradle ./gradle

# Give permission to execute the gradle script
RUN chmod +x ./gradlew

# Copy the rest of the application source code
COPY . .

# Use Gradle to build the application
# Construir el JAR (sin tests para acelerar)
RUN ./gradlew clean build -x test --stacktrace

# Set up a second stage, which will only keep the compiled application and not the build tools and source code
FROM amazoncorretto:17-alpine

# Set the working directory to '/app'
WORKDIR /app

# Copy the jar file from the first stage
COPY --from=build /app/build/libs/*.jar app.jar

# Variables de entorno para JVM
ENV JAVA_OPTS="-Xms64m -Xmx450m -XX:+UseZGC -XX:MaxMetaspaceSize=128m -XX:CompressedClassSpaceSize=32m -XX:+HeapDumpOnOutOfMemoryError -XX:MaxGCPauseMillis=200 -XX:InitiatingHeapOccupancyPercent=35 -Xlog:gc*:file=gc.log:time,uptime,level,tags:filecount=5,filesize=10m -Xss512k"

# Set the startup command to execute the jar
CMD ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]