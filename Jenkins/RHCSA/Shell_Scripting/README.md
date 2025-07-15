# Lab 1: Automating MySQL Database Backup with Shell Script and Cron

This task showcases how to automate the process of backing up a MySQL database using a shell script. The script is scheduled to run daily using a cron job to ensure backups are consistently created and stored in a dedicated directory.

---

## 🎯 Objective

- Set up daily automated backups for MySQL.
- Save backups in a specific directory with date-based filenames.
- Run the backup script daily without manual execution.

---

## 🧰 Requirements

- RHEL/CentOS-based Linux system
- Installed MySQL server
- Terminal access with `cron` permissions
- Basic shell scripting knowledge

---
### 1️⃣ Install MySQL Server (CentOS/RHEL)

```bash
sudo dnf install mysql-server -y
sudo systemctl enable mysqld
sudo systemctl start mysqld

2️⃣ Create a Backup Directory
sudo mkdir -p /opt/mysql_backups
sudo chown $USER:$USER /opt/mysql_backups

3️⃣ Create the Backup Script
nano /opt/mysql_backups/mysql_backup.sh
#!/bin/bash

DATE=$(date +%F)
BACKUP_FILE="/opt/mysql_backups/MySQL_backup_${DATE}.sql"

mysqldump -u root --all-databases > "$BACKUP_FILE"

--------------Make it executable:
   chmod +x /opt/mysql_backups/mysql_backup.sh

4️⃣ Automate with Cron
crontab -e
to schedule it at 5:00 PM every day  
0 17 * * * /opt/mysql_backups/mysql_backup.sh


✅ Key Benefits
Fully automated backup process

Easy to customize and scale

Organized storage structure with dated filenames

✍️ Author
Mohamed Anter — Red Hat Linux Admin Lab
