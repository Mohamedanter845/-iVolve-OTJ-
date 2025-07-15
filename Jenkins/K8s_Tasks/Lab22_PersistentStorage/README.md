# Lab 22: Persistent Storage Setup for Application Logging

## 🎯 Objective

Set up persistent storage using **Persistent Volumes** and **Persistent Volume Claims** to store application logs.

---

## 🏗️ Setup Overview

- **Persistent Volume (PV)**:
  - Size: `1Gi`
  - Path: `/mnt/app-logs` on node
  - Access Mode: `ReadWriteMany (RWX)`
  - Reclaim Policy: `Retain`

- **Persistent Volume Claim (PVC)**:
  - Requests 1Gi
  - Matches PV access mode `RWX`

---

## 📝 Steps

### Step 1: Create Storage Path on Node
```bash
minikube ssh -n taint-lab-m02
sudo mkdir -p /mnt/app-logs
sudo chmod 777 /mnt/app-logs
```
Step 2: Define and Apply PV
```bash
# pv.yaml
apiVersion: v1
kind: PersistentVolume
metadata:
  name: app-logs-pv
spec:
  capacity:
    storage: 1Gi
  accessModes:
    - ReadWriteMany
  hostPath:
    path: /mnt/app-logs
  persistentVolumeReclaimPolicy: Retain
```
Step 3: Define and Apply PVC
```bash
# pvc.yaml
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: app-logs-pvc
spec:
  accessModes:
    - ReadWriteMany
  resources:
    requests:
      storage: 1Gi
````
Step 4: Create Pod to Write Logs
```bash
# log-writer-pod.yaml
apiVersion: v1
kind: Pod
metadata:
  name: log-writer
spec:
  containers:
  - name: logger
    image: busybox
    command: ["/bin/sh", "-c"]
    args: ["while true; do echo '📄 Logging from pod at $(date)' >> /mnt/app-logs/log.txt; sleep 5; done"]
    volumeMounts:
    - mountPath: /mnt/app-logs
      name: log-volume
  volumes:
  - name: log-volume
    persistentVolumeClaim:
      claimName: app-logs-pvc
```
✅ Verification
```bash
kubectl exec -it log-writer -- tail -f /mnt/app-logs/log.txt


[!verificationimage](lab22_1.PNG)
```
-----------------------

