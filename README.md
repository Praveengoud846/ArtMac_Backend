# Task Tracker Application

A simple Spring Boot application to manage tasks.  
This project was built as part of a technical evaluation to demonstrate skills in Java, Spring Boot, REST API development, and clean code practices.

---

## Features

- ✅ Create, view, update, and delete tasks
- ✅ Task statuses: `PENDING` and `DONE`
- ✅ Filter tasks by status
- ✅ RESTful API design principles
- ✅ Input validation using DTO and JSR-380 (`@Valid`)
- ✅ Clean architecture: Controller → Service → Repository
- ✅ PostgreSQL for persistent storage

---

## Technologies Used

- Spring Boot 3.x
- Spring Web (REST API)
- Spring Data JPA
- PostgreSQL
- Hibernate
- Maven

---

## 🛠️ Setup Instructions

### 1. Clone the Repository

git clone https://github.com/Praveengoud846/ArtMac_Backend -b artmac_backend
cd ArtMac_Backend

2. Configure PostgreSQL
Make sure PostgreSQL is running locally.
Update your application.properties with your DB credentials:

properties
Copy
Edit
spring.datasource.url=jdbc:postgresql://localhost:5432/taskdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

The app will start at:
📍 http://localhost:8080
