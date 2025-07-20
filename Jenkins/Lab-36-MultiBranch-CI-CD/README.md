# Lab 36: Multi-Branch CI/CD Workflow with Jenkins, Docker, and Kubernetes

## **Overview**
This lab demonstrates a complete CI/CD pipeline using **Jenkins Multibranch Pipeline**, **Docker**, and **Kubernetes**.  
The pipeline is triggered by changes in three Git branches:  
- **main** (Production environment)  
- **stag** (Staging environment)  
- **dev** (Development environment)  

Each branch deploys its application version into a **dedicated Kubernetes namespace**.

---

## **Pipeline Workflow**
1. **Code Checkout:** Jenkins pulls the Dockerfile and application code from GitHub.
2. **Build Application:** Maven builds the Java application and generates the `.jar` file.
3. **Docker Build & Push:** A Docker image is built and pushed to Docker Hub.
4. **Kubernetes Deployment:**  
   - Each branch updates its corresponding namespace (`main`, `stag`, `dev`).  
   - Kubernetes manifests are applied automatically via Jenkins.
5. **Multi-Branch Strategy:** Each branch has its own environment.

---

## **Project Structure**
Jenkins_App/
│
├── Dockerfile
├── Jenkinsfile
├── k8s/
│ ├── deployment.yaml
│ └── service.yaml

-------------------
Create 3 branches:
```bash
git checkout -b main
git push origin main
git checkout -b stag
git push origin stag
git checkout -b dev
git push origin dev
```
---------------------------
2. Kubernetes Namespaces
```bash
kubectl create namespace main
kubectl create namespace stag
kubectl create namespace dev
```
-------------
3. Jenkins Configuration
```bash
Install Plugins:

Pipeline

Docker Pipeline

Kubernetes CLI

Git

Create Multibranch Pipeline:

Link your repository.

Jenkins will automatically discover main, stag, and dev branches.

Shared Library:

Create a shared library repository.

Configure it under Manage Jenkins → Global Pipeline Libraries.

````
![Lab 36 Screenshot](lab36_1.PNG)

Access Application:
kubectl get svc -n main
kubectl get svc -n stag
kubectl get svc -n dev
----------------------------------------------------
Technologies Used
```bash
Jenkins (Multibranch Pipeline, Shared Library)

Docker (Build & Push images)

Kubernetes (Namespaces & Deployments)

Maven (Java App Build)

GitHub (Version Control)
```
----------------------------------

