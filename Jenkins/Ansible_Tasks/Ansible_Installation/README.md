✅ Ansible Installation Lab
This lab demonstrates how to:
--Install and verify Ansible on a control node (VM1).

--Create an SSH key and share it with a managed node (VM2).

--Build a simple inventory file for Ansible.

--Test communication between the control node and managed node using ansible -m ping.

🧱 Environment
Node	Role	IP Address
VM1	Control Node	192.168.254.131
VM2	Managed Node	192.168.254.133

---------------------------------------------------
🪛 Steps
✅ Installed Ansible on VM1:
sudo dnf install epel-release -y
sudo dnf install ansible -y

🔐 Generated SSH key on VM1:

ssh-keygen

📤 Shared key with VM2:
ssh-copy-id mohamedanter@192.168.254.133


🏗️ Created inventory file:
[managed]
192.168.254.133 ansible_user=mohamedanter


✅ Tested connectivity:
ansible -i inventory managed -m ping

📁 Files Included
inventory

README.md
ssh_config.txt

