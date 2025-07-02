# Stage 1: Build using Maven
FROM maven:3.9.10-eclipse-temurin-17-alpine as build

WORKDIR /app
COPY . .
RUN mvn package

# Stage 2: Run with Java only
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]

