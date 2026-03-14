# Use the official maven/Java 8 image to create a build artifact.
# https://hub.docker.com/_/maven
FROM eclipse-temurin:21

RUN groupadd spring && useradd -g spring spring
USER spring:spring

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY run_service.sh ./
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ./app.jar

# Run the web service on container startup.
ENTRYPOINT ["./run_service.sh"]
