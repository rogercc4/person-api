# Dockerfile

# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

# The application's jar file
ARG JAR_FILE=../target/*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/app.jar"]

# Make port 8086 available to the world outside this container
EXPOSE 8086