# Lab 19: Node Isolation Using Taints in Kubernetes

## 🧪 Objective

Isolate Kubernetes workloads by tainting nodes to restrict pod scheduling unless explicitly tolerated.

---

## ⚙️ Lab Setup

- **Tool Used**: Minikube
- **OS**: CentOS 9 VM
- **Kubernetes Nodes**: 3 nodes (control-plane, app, database)

---

## 🛠️ Steps

### ✅ Step 1: Start Multi-node Minikube Cluster

```bash
minikube start --nodes 3 -p taint-lab
```

✅ Step 2: Apply Taints

```bash
kubectl taint nodes taint-lab workload=master:NoSchedule
kubectl taint nodes taint-lab-m02 workload=app:NoSchedule
kubectl taint nodes taint-lab-m03 workload=database:NoSchedule
```

✅ Step 3: Create Pods with Matching Tolerations

```bash 
kubectl apply -f master-pod.yaml
kubectl apply -f app-pod.yaml
kubectl apply -f db-pod.yaml
```
✅ Step 4: Validate Scheduling
```bash
kubectl get pods -o wide
```
![Lab Screenshot](./images/lab19_1.PNG)
```
✅ Lab Result.
```bash
| Pod        | Node          |
| ---------- | ------------- |
| master-pod | taint-lab     |
| app-pod    | taint-lab-m02 |
| db-pod     | taint-lab-m03 |
````
📚 Summary
This lab demonstrated how taints and tolerations are used to control pod placement across Kubernetes nodes. Pods without toleration will be Pending if scheduled on a tainted node. Pods with correct toleration will be allowed.

yaml
Copy
Edit

