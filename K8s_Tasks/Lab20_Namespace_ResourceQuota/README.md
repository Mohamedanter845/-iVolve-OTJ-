# Lab 20: Namespace Management and Resource Quota Enforcement

## 🎯 Objective

Implement namespace isolation in Kubernetes and enforce resource quotas to limit the number of pods.

---

## ⚙️ Environment

- 🖥️ OS: CentOS
- ☸️ Kubernetes: Minikube (single-node setup)
- 📁 Namespace: `ivolve`

---

## 🛠️ Steps

### ✅ Step 1: Create a Namespace

```bash
kubectl create namespace ivolve
```
✅ Step 2: Apply Resource Quota
```bash
apiVersion: v1
kind: ResourceQuota
metadata:
  name: pod-quota
  namespace: ivolve
spec:
  hard:
    pods: "2"
```
```
kubectl apply -f quota.yaml
```
✅ Step 3: Create Pods inside the Namespace
```bash
apiVersion: v1
kind: Pod
metadata:
  name: nginx-pod
  namespace: ivolve
spec:
  containers:
  - name: nginx
    image: nginx
```
step4
```bash
cp pod.yaml pod2.yaml
cp pod.yaml pod3.yaml
```

🧪 Apply pods:
```bash
kubectl apply -f pod.yaml
kubectl apply -f pod2.yaml
kubectl apply -f pod3.yaml  
```
✅ Step 4: Check Pod & Quota Status

#### 🔹 Pod Creation
![lab20_1](images/lab20_1.PNG)

#### 🔹 Quota Status
![lab20_2](images/lab20_2.PNG)

#### 🔹 Third Pod Pending
![lab20_3](images/lab20_3.PNG)

-------------------------

