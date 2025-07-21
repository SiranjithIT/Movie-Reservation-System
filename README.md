## 🚀 How to Run and Test the Application

Follow the steps below to clone and run the Movie Reservation System using Docker:

---

### 1. 📦 Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/SiranjithIT/Movie-Reservation-System.git
```

---

### 2. 🐳 Install Docker Desktop

Make sure Docker Desktop is installed and running on your system.  
👉 [Download Docker Desktop](https://www.docker.com/products/docker-desktop)

---

### 3. 📁 Navigate to the Project Directory

Navigate into the cloned project directory:

```bash
cd path/to/Movie-Reservation-System
```

---

### 4. 🛠️ Build the Project

Build the Maven project while skipping tests(make sure that proper maven file is downloaded(https://maven.apache.org/download.cgi) and placed in proper program file):

```bash
mvn clean package -DskipTests
```

---

### 5. 🚢 Run the Application with Docker Compose

Start all required containers and services:

```bash
docker-compose up --build
```

---

### ✅ Done!

Your application should now be running. You can test the API using:
- 🔧 Postman
- 🌐 Web browser
- 🖥️ Curl or any other API testing tool

---
