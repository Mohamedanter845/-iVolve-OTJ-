# 🧩 Lab 5: Ansible Playbook – Web Server Configuration

## 📌 Objective:
Automate the installation and configuration of an Nginx web server using an Ansible playbook.

---

## 🛠️ Tasks Performed:

- Install **Nginx** on the managed node
- Ensure the service is **running** and **enabled**
- Replace the default web page with a custom HTML message

---

## 📁 Playbook Used

### `webserver.yml`
```yaml
- name: Install and configure Nginx web server
  hosts: managed
  become: true

  tasks:
    - name: Install Nginx
      ansible.builtin.yum:
        name: nginx
        state: present

    - name: Ensure Nginx is running and enabled
      ansible.builtin.service:
        name: nginx
        state: started
        enabled: true

    - name: Customize the index.html page
      ansible.builtin.copy:
        content: "<h1>Welcome from Mohamed's Ansible Playbook 🚀</h1>"
        dest: /usr/share/nginx/html/index.html


✅ Result:
curl localhost
# Output:
<h1>Welcome from Mohamed's Ansible Playbook 🚀</h1>



📍 Inventory Configuration (sample):

[managed]
192.168.254.133 ansible_user=mohamedanter ansible_become=true ansible_become_password=your_password



📦 Folder Structure
-----------------
Ansible_Tasks/
└── WebServer_Playbook/
    ├── webserver.yml
    └── README.md

