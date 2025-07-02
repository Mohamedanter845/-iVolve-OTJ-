# Lab 16: Docker Compose for Node.js and PostgreSQL

## 🎯 Objective
Set up a Node.js app with a PostgreSQL database using Docker Compose.

---
## 🧱 Project Structure

docker6/
├── app.js
├── package.json
├── Dockerfile
├── docker-compose.yml
└── README.md

## 🧪 Steps

### 1. Clone the Repo & Navigate
bash
git clone https://github.com/Ibrahim-Adel15/Docker-4.git
cd Docker-4


Create docker-compose.yml
```bash
version: '3.8'

services:
  app:
    build: .
    ports:
      - "3000:3000"
    depends_on:
      - db
    networks:
      - mynet

  db:
    image: postgres:15-alpine
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
      POSTGRES_DB: postgres
    volumes:
      - postgres_data:/var/lib/postgresql/data
    ports:
      - "5432:5432"
    networks:
      - mynet

volumes:
  postgres_data:

networks:
  mynet:
```

 Run the App
```bash
sudo docker compose up -d
```
Verify Everything
```bash
curl http://localhost:3000
# Output: PostgreSQL Connection Test App
```
[!image](lab16_.PNG)


## 📂 Data Persistence

PostgreSQL data is stored in a named volume:
```bash
postgres_data -> /var/lib/postgresql/data
```
-------------------------------
## 🧹 Cleanup

Stop and remove containers, network, and volume:

```bash
docker compose down -v
```
-------------------------
## 📝 Notes

- Make sure Docker and Docker Compose are installed.
- Use `docker compose logs -f` to monitor logs.
- Use `docker ps` to verify containers are running.

---

