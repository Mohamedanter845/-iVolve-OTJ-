# Lab23: MySQL StatefulSet on Kubernetes with Persistent Storage

This lab demonstrates how to deploy a MySQL database as a **StatefulSet** in Kubernetes using:
- Secrets for sensitive data
- Persistent Volumes for data durability
- Headless service for stable network identity
- Tolerations for node scheduling

---

## 📁 Project Structure

```bash
Lab23_StatefulSet_MySQL/
├── mysql-secret.yaml
├── mysql-pv.yaml
├── mysql-pvc.yaml (optional if PVC inside StatefulSet)
├── statefulset.yaml
├── headless-svc.yaml
```


---

## ⚙️ Prerequisites

- Minikube (profile name: `taint-lab`)
- Node label or taint for `workload=database`
- Enough disk space (~2GB free on root)

---

## 🛠️ Step-by-Step Instructions

### 1. Start Minikube Cluster
```bash
minikube start -p taint-lab --memory=2200mb --cpus=2
kubectl config use-context taint-lab

```
2. Create Host Path Directory on Worker Node
```bash
minikube ssh -n taint-lab-m03
sudo mkdir -p /mnt/mysql-data
sudo chmod 777 /mnt/mysql-data
```
3. Create Kubernetes Secret
```bash
kubectl apply -f mysql-secret.yaml
```
Contents of mysql-secret.yaml:
```bash
apiVersion: v1
kind: Secret
metadata:
  name: mysql-secret
type: Opaque
data:
  MYSQL_ROOT_PASSWORD: cm9vdDEyMw==  # base64 for "root123"
````
4. Create PersistentVolume (PV)
```bash
apiVersion: v1
kind: PersistentVolume
metadata:
  name: mysql-pv
spec:
  capacity:
    storage: 1Gi
  accessModes:
    - ReadWriteOnce
  hostPath:
    path: /mnt/mysql-data
  storageClassName: standard
````
5. Create Headless Service

```bash
apiVersion: v1
kind: Service
metadata:
  name: mysql-headless
spec:
  ports:
    - port: 3306
  clusterIP: None
  selector:
    app: mysql
```
6. Deploy StatefulSet
```bash
kubectl apply -f statefulset.yaml
```
7. Verify Everything is Working
Check Pod Status
```bash
kubectl get pods
kubectl get pvc
kubectl get pv
kubectl get svc
````
Enter Pod
```bash
kubectl exec -it mysql-0 -- /bin/bash
````
✅ Final Status (Success)
```bash
Pod is Running

PVC is Bound

StatefulSet is working

You can exec into container and use mysql

```
-------------------------------------------------------------------------
```bash
[!images](lab23_1.PNG)
[!images](lab23_2.PNG)
[!images](lab23_3.PNG)
```
----------------------------------------------------------------------
