# Lab 21: Managing Configuration and Sensitive Data with ConfigMaps and Secrets

This lab demonstrates how to manage configuration data and sensitive credentials for a MySQL setup in Kubernetes using ConfigMaps and Secrets.

---

## 🎯 Objectives

- Store **non-sensitive MySQL configuration** in a ConfigMap
- Store **sensitive MySQL credentials** in a Secret using base64 encoding

---

## 🧾 Resources

### ✅ ConfigMap: `mysql-config`

Stores non-sensitive data:

| Key      | Value            |
|----------|------------------|
| DB_HOST  | mysql-service    |
| DB_USER  | ivolveuser       |

Command to view:
```bash
kubectl describe configmap mysql-config -n ivolve
```

---

### 🔐 Secret: `mysql-secret`

Stores sensitive data (base64 encoded):

| Key                 | Value (decoded) |
|---------------------|-----------------|
| DB_PASSWORD         | ivolvepass      |
| MYSQL_ROOT_PASSWORD | rootpass        |

Command to decode:
```bash
echo aXZvbHZlcGFzcw== | base64 --decode
echo cm9vdHBhc3M= | base64 --decode
```

Command to view:
```bash
kubectl get secret mysql-secret -n ivolve -o yaml
```

: Deploy Pod with Config & Secret
```bash
# pod.yaml
apiVersion: v1
kind: Pod
metadata:
  name: mysql-app
  namespace: ivolve
spec:
  containers:
  - name: app-container
    image: alpine
    command: [ "sleep", "3600" ]
    env:
    - name: DB_HOST
      valueFrom:
        configMapKeyRef:
          name: app-config
          key: DB_HOST
    - name: DB_USER
      valueFrom:
        configMapKeyRef:
          name: app-config
          key: DB_USER
    - name: DB_PASSWORD
      valueFrom:
        secretKeyRef:
          name: app-secret
          key: DB_PASSWORD
    - name: MYSQL_ROOT_PASSWORD
      valueFrom:
        secretKeyRef:
          name: app-secret
          key: MYSQL_ROOT_PASSWORD
```

 Verify Inside Pod

```bash
kubectl exec -it mysql-app -n ivolve -- /bin/sh

echo $DB_HOST              # should return: mysql-service
echo $DB_USER              # should return: ivolve_user
echo $DB_PASSWORD          # should return: ivolve_pass
echo $MYSQL_ROOT_PASSWORD  # should return: root123
````
```bash
[!image](lab21_1.PNG)
```
🏁 Conclusion

```bash
This lab demonstrates how to:

Separate sensitive and non-sensitive configurations

Safely inject them into Pods

Use base64 to secure secret values

Using ConfigMap and Secret is a best practice to decouple app configs and secrets from code.
```
🧠 Pro Tip: Never store raw passwords or secrets directly in deployment files — always encode or externalize them securely.


