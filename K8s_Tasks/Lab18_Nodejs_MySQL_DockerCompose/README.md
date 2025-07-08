# Lab 18 - Node.js + MySQL App with Docker Compose 🐳

This lab demonstrates how to containerize a simple Node.js application that connects to a MySQL database using **Docker Compose**. The setup includes automatic database initialization and product seeding.

```bash 
Lab18_Nodejs_MySQL_DockerCompose/
├── app/ # Node.js application (cloned from GitHub)
├── db_data/ # MySQL volume data (auto-created)
├── .env # Environment variables
├── docker-compose.yml # Compose file to spin up app + db
└── README.md # This file
```


---

## ⚙️ Services

### 1️⃣ **Node.js App**
- Port: `3000`
- Features:
  - Connects to MySQL
  - Initializes a `products` table
  - Seeds initial products if empty
  - Displays them in a frontend

### 2️⃣ **MySQL Database**
- Image: `mysql:5.7`
- Port: `3306`
- Uses volume: `./db_data` for persistence

---

## 🔐 Environment Variables (`.env`)

```env
MYSQL_ROOT_PASSWORD=rootpassword
MYSQL_DATABASE=ivolve
MYSQL_USER=user
MYSQL_PASSWORD=password

DB_HOST=db
DB_NAME=ivolve
DB_USER=user
DB_PASSWORD=password
```


---------------
🚀 How to Run
```bash
# Step 1: Clone the app repo into the 'app' folder
git clone https://github.com/Ibrahim-Adel15/kubernets-app app

# Step 2: Start the services
sudo docker compose up -d

# Step 3: Check container logs
sudo docker compose logs -f app
```
🌐 Access the App
Visit: http://localhost:3000


📚 Notes
```bash
Make sure Docker and Docker Compose are installed.

This is part of the K8s_Tasks folder, as a preparatory step before converting this setup into Kubernetes manifests in future labs.
```
