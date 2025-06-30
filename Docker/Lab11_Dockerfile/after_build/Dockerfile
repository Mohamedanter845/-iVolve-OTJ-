FROM maven:3.9.10-eclipse-temurin-17-alpine
WORKDIR /app
COPY ../before_build/Docker-1/ .
RUN mvn package
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
