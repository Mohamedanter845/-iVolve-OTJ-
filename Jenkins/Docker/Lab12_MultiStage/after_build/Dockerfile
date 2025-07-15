# First stage: build the app
FROM maven:3.9.10-eclipse-temurin-17-alpine AS build

# Create app directory
WORKDIR /app

# Copy application source code
COPY ../before_build/Docker-1/ .

# Package the application
RUN mvn package



# Second stage: run the app
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
