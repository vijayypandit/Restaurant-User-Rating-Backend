# 🍽️ Restaurant User Rating System 🌟

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java" alt="Java 17">
  <img src="https://img.shields.io/badge/Spring_Boot-3.0.x-green?style=for-the-badge&logo=springboot" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Microservices-Architecture-blue?style=for-the-badge" alt="Microservices">
  <img src="https://img.shields.io/badge/MySQL-PostgreSQL-blue?style=for-the-badge&logo=mysql" alt="Databases">
</p>

---

## 🎯 Objective
This project is a high-performance **Restaurant User Rating System** built using a modern **Microservices Architecture**. It enables users to explore restaurants, provide ratings, and manage profiles, with each service handling a specific domain independently.

Developed with a focus on fault tolerance, independent scalability, and clean service-to-service communication.

---

## 🚀 Tech Stack
*   **Core:** ☕ Java 17, Spring Boot 3.0.x
*   **Infrastructure:** ☁️ Spring Cloud (Eureka Service Registry, API Gateway)
*   **Persistence:** 🗄️ PostgreSQL (User), MySQL (Restaurant), MongoDB (Rating)
*   **Tools:** 🛠️ Maven, Lombok, Hibernate JPA

---

## 🏗️ Project Structure
The ecosystem consists of **five** powerful microservices:

*   **`ServiceRegstry`** 🗼 — The heart of the system (Netflix Eureka) for service discovery.
*   **`ApiGateway`** 🌉 — The unified entry point for all client requests.
*   **`UserService`** 👤 — Manages user profiles and authentication data.
*   **`RestaurantService`** 🍱 — Handles restaurant metadata and business logic.
*   **`RatingService`** ⭐ — Manages user-submitted ratings and reviews.

---

## 🌎 API Gateway Access (Port: 8084)
The API Gateway serves as the single entrance to your ecosystem. It intelligently routes traffic to the target microservice based on the URL path.

| Gateway Route 🛣️ | Destination Service |
| :--- | :--- |
| `GET/POST http://localhost:8084/users/**` | `UserService` |
| `GET/POST http://localhost:8084/restaurants/**` | `RestaurantService` |
| `GET/POST http://localhost:8084/ratings/**` | `RatingService` |
| `GET http://localhost:8084/staffs/**` | `UserService` (Gateway configured) |

---

## 🗺️ API Endpoints Summary

### 👤 User Service
| Method | Endpoint | Description | Emoji |
| :--- | :--- | :--- | :---: |
| `POST` | `/users` | Create a new user account | 🆕 |
| `GET` | `/users` | Fetch list of all registered users | 👥 |
| `GET` | `/users/{userId}` | Retrieve details for a specific user | 👤 |

### 🍱 Restaurant Service
| Method | Endpoint | Description | Emoji |
| :--- | :--- | :--- | :---: |
| `POST` | `/restaurants` | Add a new restaurant to the system | 🏪 |
| `GET` | `/restaurants` | Fetch list of all available restaurants | 🍛 |
| `GET` | `/restaurants/{id}` | Get details for a single restaurant | 🍴 |
| `GET` | `/staff` | List staff members (internal) | 👨‍🍳 |

### ⭐ Rating Service
| Method | Endpoint | Description | Emoji |
| :--- | :--- | :--- | :---: |
| `POST` | `/ratings` | Submit a new user rating/review | ✍️ |
| `GET` | `/ratings` | Fetch all ratings from the database | 📊 |
| `GET` | `/ratings/users/{id}` | Get all ratings provided by a specific user | 🔍 |
| `GET` | `/ratings/restaurants/{id}`| Get all ratings for a specific restaurant | 🏢 |

---

## ⚙️ Setup & Execution

### 📋 Prerequisites
1.  **JDK 17** and **Maven** installed.
2.  **PostgreSQL**, **MySQL**, and **MongoDB** instances running.
3.  Databases created: `microservice` (Postgres) and `microservices` (MySQL).

### 🏃 Running the Services
Start the services in the following order:

1.  **Service Registry** (`port: 8761`)
    ```bash
    cd ServiceRegstry/ServiceRegstry && mvn spring-boot:run
    ```
2.  **Core Services** (User, Restaurant, Rating)
    ```bash
    cd [ServiceFolder]/[ServiceFolder] && mvn spring-boot:run
    ```
3.  **API Gateway** (`port: 8084`)
    ```bash
    cd ApiGateway && mvn spring-boot:run
    ```

---

## 🔮 Roadmap (Future Enhancements)
- [ ] **Config Server:** Centralized config management.
- [ ] **OAuth2/JWT:** Secure service communication.
- [ ] **Redis Caching:** Lightning-fast response times.
- [ ] **Dockerization:** Containerized deployment with Docker Compose.

---

<p align="center">
  <b>Built with ❤️ by CodeOverflow Team</b><br>
  <i>Scaling taste, one rating at a time.</i>
</p>
