# Lab 32 - Jenkins Installation

## Option 1: Install and configure Jenkins as a service on CentOS

### ✅ Steps:
1. Updated system and installed Java 11.
2. Added Jenkins official repo and imported GPG key.
3. Installed Jenkins via `yum`.
4. Enabled and started the Jenkins service.
5. Opened port 8080 on the firewall.
6. Accessed Jenkins via browser and got the initial admin password from the system.

### 🔧 Jenkins Status
Checked Jenkins status using:
```bash
sudo systemctl status jenkins
```
[!images](jenkins_1.PNG)
----------------------------------------------------
