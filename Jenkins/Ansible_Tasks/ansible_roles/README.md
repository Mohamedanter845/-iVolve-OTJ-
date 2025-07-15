# 🚀 Ansible Roles: Deploy Docker, Jenkins, and kubectl

This project automates the deployment of Docker, Jenkins, and kubectl on a managed node using Ansible roles.  
Each tool is configured through a dedicated role for modularity and reusability.

---

## 📁 Directory Structure

ansible_roles/
├── README.md
├── deploy.yml
└── roles/
├── docker/
│ └── tasks/
│ └── main.yml
├── jenkins/
│ └── tasks/
│ └── main.yml
└── kubectl/
└── tasks/
└── main.yml



---

## 🎯 Objective

- Automate installation and configuration of:
  - Docker
  - Jenkins
  - kubectl
- Use Ansible roles for separation of concerns.
- Validate functionality through ad-hoc checks and service status.

---

## 🛠️ Steps to Reproduce

### 1. Create Project Directory
```bash
mkdir -p ~/Ansible_Tasks/ansible_roles
cd ~/Ansible_Tasks/ansible_roles



---------
2. Generate Ansible Roles
ansible-galaxy init roles/docker
ansible-galaxy init roles/jenkins
ansible-galaxy init roles/kubectl


🧩 Role Task Definitions

- name: Install required packages
  dnf:
    name: dnf-plugins-core
    state: present

- name: Add Docker repository
  command: dnf config-manager --add-repo=https://download.docker.com/linux/centos/docker-ce.repo

- name: Install Docker
  dnf:
    name:
      - docker-ce
      - docker-ce-cli
      - containerd.io
    state: latest

- name: Start and enable Docker
  service:
    name: docker
    state: started
    enabled: true



📦 jenkins/tasks/main.yml
- name: Install Java 17
  dnf:
    name: java-17-openjdk
    state: present

- name: Add Jenkins repository
  get_url:
    url: https://pkg.jenkins.io/redhat-stable/jenkins.repo
    dest: /etc/yum.repos.d/jenkins.repo

- name: Import Jenkins GPG key
  rpm_key:
    state: present
    key: https://pkg.jenkins.io/redhat-stable/jenkins.io.key

- name: Install Jenkins
  dnf:
    name: jenkins
    state: latest

- name: Start and enable Jenkins
  service:
    name: jenkins
    state: started
    enabled: true


📦 kubectl/tasks/main.yml

- name: Download kubectl binary
  get_url:
    url: https://dl.k8s.io/release/v1.27.4/bin/linux/amd64/kubectl
    dest: /usr/local/bin/kubectl
    mode: '0755'


📋 Inventory File

[managed]
192.168.254.133 ansible_user=mohamedanter ansible_ssh_private_key_file=~/.ssh/id_rsa



▶️ Run Playbook

ansible-playbook -i inventory deploy.yml



✅ Verification

SSH into managed node

ssh mohamedanter@192.168.254.133



🧠 Notes

Make sure to use Java 17 or higher. Jenkins fails on Java 11.

Use systemctl and journalctl -xeu jenkins.service for troubleshooting.

Ensure firewall and SELinux settings allow Jenkins port (default: 8080).



Made with ❤️ by Mohamed Anter
