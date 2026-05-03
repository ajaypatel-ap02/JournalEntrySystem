# Journal Entry System

A backend REST API project built using Java, Spring Boot, and MongoDB Atlas for managing journal entries.
This project demonstrates CRUD operations, REST API development, MongoDB integration, and layered architecture using Spring Boot.

---

# Features

* Create Journal Entries
* Read All Journal Entries
* Read Journal Entry by ID
* Update Existing Journal Entries
* Delete Journal Entries
* MongoDB Atlas Integration
* RESTful API Design
* Layered Architecture

  * Controller Layer
  * Service Layer
  * Repository Layer

---

# Tech Stack

* Java
* Spring Boot
* Spring Web
* Spring Data MongoDB
* MongoDB Atlas
* Maven
* Postman (for API testing)

---

# Project Structure

```text id="t5p9ws"
src
 ├── main
 │   ├── java
 │   │   └── com/Ajay/JournalEntrySystem
 │   │       ├── controller
 │   │       ├── entity
 │   │       ├── repository
 │   │       ├── services
 │   │       └── JournalEntrySystemApplication.java
 │   └── resources
 │       └── application.properties
 └── test
```

---

# API Endpoints

## Base URL

```text id="h7r4dx"
http://localhost:8080/journal
```

## Create Journal Entry

```http id="j3k6fa"
POST /journal
```

### Request Body

```json id="z8m1pv"
{
  "title": "My First Journal",
  "content": "Today I started learning Spring Boot."
}
```

---

## Get All Journal Entries

```http id="u2c9ne"
GET /journal
```

---

## Get Journal Entry By ID

```http id="f5q8lb"
GET /journal/id/{id}
```

---

## Update Journal Entry

```http id="d7v2rk"
PUT /journal/id/{id}
```

### Request Body

```json id="w4x9sm"
{
  "title": "Updated Title",
  "content": "Updated journal content."
}
```

---

## Delete Journal Entry

```http id="n6y1qt"
DELETE /journal/id/{id}
```

---

# MongoDB Configuration

Create an `application.properties` file inside:

```text id="e8k3zh"
src/main/resources/
```

Add your MongoDB Atlas connection string:

```properties id="p4s7vn"
spring.data.mongodb.uri=YOUR_MONGODB_ATLAS_URI
spring.data.mongodb.database=journaldb
```

Example:

```properties id="g1t6mc"
spring.data.mongodb.uri=mongodb+srv://username:password@cluster.mongodb.net/
spring.data.mongodb.database=journaldb
```

---

# How to Run the Project

## Clone Repository

```bash id="b9q2ld"
git clone https://github.com/YOUR_USERNAME/JournalEntrySystem.git
```

## Navigate to Project Folder

```bash id="c5w8ra"
cd JournalEntrySystem
```

## Run Application

Using Maven Wrapper:

```bash id="k7m3xe"
./mvnw spring-boot:run
```

Windows:

```bash id="v2n9fu"
mvnw.cmd spring-boot:run
```

---

# Testing APIs

You can test APIs using:

* Postman
* Thunder Client
* cURL

---

# Future Improvements

* User Authentication with Spring Security + JWT
* Validation and Exception Handling
* Swagger/OpenAPI Documentation
* Docker Deployment
* Frontend Integration
* Pagination and Search
* Role-Based Access Control

---

# Learning Objectives

This project helped in understanding:

* REST API development
* CRUD operations
* MongoDB integration with Spring Boot
* Dependency Injection
* Repository Pattern
* Layered Architecture
* API testing using Postman

---

# Author

Ajay Patel
