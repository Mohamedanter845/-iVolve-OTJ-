# Lab17 - Docker Image Vulnerability Scanning with Trivy

This lab demonstrates how to build a multi-stage Spring Boot application Docker image, scan it using **Trivy**, and optionally push it to Docker Hub.

## 🛠️ Steps

### 1. Project Structure

```bash
Lab17_TrivyScan/
├── Dockerfile
├── README.md
├── before_scan/
│ ├── pom.xml
│ └── src/
```
## 1. Install Trivy

```bash
sudo apt install wget -y
wget https://github.com/aquasecurity/trivy/releases/latest/download/trivy_0.50.1_Linux-64bit.deb
sudo dpkg -i trivy_0.50.1_Linux-64bit.deb
trivy --version
```
## 2. Clone the Application Repository
```bash
git clone https://github.com/Ibrahim-Adel15/Docker-1.git
cd Docker-1
```
# Stage 1: Build using Maven
FROM maven:3.9.10-eclipse-temurin-17-alpine as build

 Create Dockerfile
```bash
WORKDIR /app
COPY ../before_scan/Docker-1/ .
RUN mvn package

# Stage 2: Run with Java only
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
```
✅ 4. Build Docker Image
## 4. Build Docker Image
```bash
sudo docker build -t springboot-trivy-app -f after_scan/Dockerfile .
````
Replace `your-image-name` with your DockerHub username/image name.
```bash
docker build -t your-image-name .
```


 Scan Image with Trivy
```bash
trivy image --format json --output trivy-report.json your-image-name
sudo trivy image --timeout 10m springboot-trivy-app

```

 Push Image to DockerHub
```bash
docker login
docker push your-image-name
```
[!image](lab17_1.PNG)


----------------------
✅ Sample Output (Summary)
```bash
Alpine Vulnerabilities: 0

JAR Vulnerabilities: 26

CRITICAL: 1

HIGH: 12

MEDIUM: 9

LOW: 4
```
---------------------
🔐 Tools Used
--Docker

--Maven

--Trivy
📦 Docker Hub Link
```bash
https://hub.docker.com/r/mohamedanter845/springboot-trivy-app
```
