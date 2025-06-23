# 🧱 Disk Management & LVM Lab

This lab demonstrates creating partitions, volume groups, and logical volumes using LVM on CentOS.

## 📌 Goal
- Create two partitions from a 6GB disk: 2GB and 3GB.
- Use the 2GB partition to create a Volume Group.
- Create a 1GB Logical Volume.
- Extend the LV by 2GB using the second partition.
- Format and mount the LV for use.

---

## 🛠️ Steps 

### 1️⃣ Partition the Disk

sudo fdisk /dev/sdb
# Create /dev/sdb1 with +2G
# Create /dev/sdb2 with +3G

2️⃣ Create Physical Volumes
sudo pvcreate /dev/sdb1
sudo pvcreate /dev/sdb2

3️⃣ Create Volume Group
sudo vgcreate myvg /dev/sdb1


4️⃣ Create Logical Volume
sudo lvcreate -L 1G -n mylv myvg

5️⃣ Extend the Volume
sudo vgextend myvg /dev/sdb2
sudo lvextend -L +2G /dev/myvg/mylv
sudo resize2fs /dev/myvg/mylv
6️⃣ Format and Mount
sudo mkfs.ext4 /dev/myvg/mylv
sudo mkdir /mnt/lvbackup
sudo mount /dev/myvg/mylv /mnt/lvbackup

📦 Verification

lsblk
df -h
