# 🔐 Ansible Vault Task - Lab 7

This lab demonstrates how to use **Ansible Vault** to store and manage sensitive information like passwords securely in your playbooks.

---

## 🧱 Project Structure


ansible_valut_task/
├── vault.yml # Encrypted file containing sensitive variables
├── vault_playbook.yml # Ansible playbook using the vault variable
└── README.md # Documentation
.


---

## 📝 Step-by-Step

### 1. 🔐 Create an encrypted file

We created a new encrypted file to store sensitive data using:

```bash
ansible-vault create vault.yml

Inside the file, we added a secure variable:


mysql_root_password: "Anter@2025"

2. 📜 Write the Playbook
- name: Use Vault Variable Example
  hosts: managed
  become: yes
  vars_files:
    - vault.yml

  tasks:
    - name: Show the Vault password
      debug:
        msg: "The MySQL password is: {{ mysql_root_password }}"

3. ▶️ Run the Playbook
ansible-playbook -i ~/Ansible_Tasks/inventory vault_playbook.yml --ask-vault-pass

4. ✅ Result
TASK [Show the Vault password]
ok: [192.168.254.133] => {
    "msg": "The MySQL password is: Anter@2025"
}






🧠 Notes
The vault.yml file is encrypted, so it can be safely stored in Git.

Always use --ask-vault-pass or --vault-password-file when running a playbook using vault files.




📌 Inventory Path
~/Ansible_Tasks/inventory

✍️ Author
Mohamed Anter - Lab 7 of Ansible Labs Series
