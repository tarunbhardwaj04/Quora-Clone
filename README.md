# Quora Clone - Backend API

A full-stack inspired social Q&A platform built using **Spring Boot**, **Spring Security**, and **MySQL**. This project demonstrates a robust implementation of social media features, including user authentication, hierarchical data relationships, and secure API design.



## 🚀 Key Features

* **Secure Authentication**: Implemented **JWT (JSON Web Tokens)** for stateless session management and **Spring Security** for role-based access control.
* **Hierarchical Entity Mapping**: Complex JPA relationships between Users, Questions, Answers, Comments, and Likes.
* **Topic-Based Categorization**: Questions are mapped to specific topics (e.g., Java, Spring Boot) for better discoverability.
* **Interaction System**: Full support for Upvoting/Downvoting and threaded commenting.
* **Robust Exception Handling**: Custom global exception handlers for `ResourceNotFound` and `BadRequest` scenarios.

## 🛠️ Tech Stack

* **Backend**: Java 17, Spring Boot 3.x
* **Security**: Spring Security, JWT (JJWT Library)
* **Data**: Spring Data JPA, Hibernate, MySQL
* **Tools**: Maven, Lombok, Postman (for API testing)



## 🏗️ Project Structure

```text
src/main/java/com/App/Quora
├── Adapters        # DTO to Entity mapping logic
├── Configuration   # Security & JWT filter setups
├── Controller      # REST API Endpoints
├── DTO             # Data Transfer Objects for requests/responses
├── Entity          # Database Models (User, Question, Topic, etc.)
├── ExceptionHandler # Global @ControllerAdvice
├── Repository      # Spring Data JPA Interfaces
└── Service         # Business Logic Layer

>>