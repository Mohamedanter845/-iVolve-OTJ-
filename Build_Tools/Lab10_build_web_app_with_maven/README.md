
# Lab 10: Build Java Web App using Maven

## 📌 Objective

This lab demonstrates how to build and run a simple Java application using **Apache Maven**. The steps include cloning a Maven-based project, compiling the code, running unit tests, generating a JAR file, executing it, and verifying its output.

---

## 📁 Folder Structure


Lab10_build_web_app_with_maven/
├── build2/ # Cloned Maven project
│ ├── pom.xml # Maven configuration file
│ └── src/ # Source code and tests
├── lab10_1.PNG # Screenshot: mvn test
├── lab10_2.PNG # Screenshot: mvn package
├── lab10_3.PNG # Screenshot: java -jar run
└── README.md



---

## ⚙️ Steps

### 1️⃣ Install Maven Manually

```bash
wget https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz -P /tmp
sudo tar xf /tmp/apache-maven-3.9.6-bin.tar.gz -C /opt/
sudo ln -s /opt/apache-maven-3.9.6 /opt/maven

---
sudo tee /etc/profile.d/maven.sh > /dev/null <<EOF
export M2_HOME=/opt/maven
export PATH=\$M2_HOME/bin:\$PATH
EOF

sudo chmod +x /etc/profile.d/maven.sh
source /etc/profile.d/maven.sh




2️⃣ Clone the Maven Project
---
git clone https://github.com/Ibrahim-Adel15/build2.git
cd build2
---

3️⃣ Run Unit Tests
---
mvn test


4️⃣ Package the Application
---
mvn package


---
5️⃣ Run the Application


java -jar target/hello-ivolve-1.0-SNAPSHOT.jar



✅ Output
---
Hello Ivolve Trainee


🧠 Summary
---
In this lab, we successfully:

Installed Apache Maven manually

Cloned a Maven Java project

Built and packaged the app

Ran the generated JAR file

Verified the output
