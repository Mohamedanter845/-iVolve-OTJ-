#!/bin/bash
DATE=$(date +%F)
BACKUP_FILE="/opt/mysql_backups/MySQL_backup_${DATE}.sql"
mysqldump -u root --all-databases > "$BACKUP_FILE"
