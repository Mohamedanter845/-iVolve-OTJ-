# Lab 33 - Role-based Authorization in Jenkins

## 🎯 Objective
Set up role-based access control in Jenkins using the **Role-based Authorization Strategy** plugin.  
Two users (`user1`, `user2`) will be created with different access levels:
- `user1`: Full Admin access.
- `user2`: Read-only access.

---

## 🧰 Prerequisites
- Jenkins installed and running (from Lab 32)
- Admin access to Jenkins
- Internet connection to install plugins

---

## ✅ Steps

### 🔧 Step 1: Install Plugin
- Go to: **Manage Jenkins → Plugin Manager → Available**
- Search for: `Role-based Authorization Strategy`
- Install it without restart ✅

📸 `screenshots/step1_plugin_installed.png`

---

### 🔧 Step 2: Enable Role-Based Authorization
- Go to: **Manage Jenkins → Configure Global Security**
- Under **Authorization**, select: `Role-Based Strategy`
- Click **Save**



---

### 🔧 Step 3: Create Users
- Navigate to: **Manage Jenkins → Manage Users → Create User**
- Create:
  - `user1` with full name `User One`
  - `user2` with full name `User two`

---

### 🔧 Step 4: Create Roles
- Go to: **Manage Jenkins → Manage and Assign Roles → Manage Roles**
- Add new roles:
  - `admin` → check all permissions
  - `readonly` → check only:
    - `Overall → Read`
    - `Job → Read`
    - `View → Read`
- Save changes.


---

### 🔧 Step 5: Assign Users to Roles
- Go to: **Manage Jenkins → Manage and Assign Roles → Assign Roles**
- Assign:
  - `user1` → `admin`
  - `user2` → `readonly`
- Click **Save**


---

### 🔧 Step 6: Test Users’ Permissions

#### ✅ Login as `user1`
- Should have full admin access:
  - Create/Edit Jobs
  - Access Manage Jenkins



#### ✅ Login as `user2`
- Should have read-only access:
  - Can view jobs and status
  - Cannot create/edit anything
