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
*   **Infrastructure:** ☁️ Spring Cloud (Eureka, API Gateway, **Config Server**)
*   **Fault Tolerance:** 🛡️ Resilience4j (Circuit Breaker, Retry)
*   **Persistence:** 🗄️ PostgreSQL (User), MySQL (Restaurant), MongoDB (Rating)
*   **Tools:** 🛠️ Maven, Lombok, Hibernate JPA

---

## 🏗️ Project Structure
The ecosystem consists of **six** powerful microservices:

*   **`ServiceRegstry`** 🗼 — Netflix Eureka for service discovery.
*   **`ApiGateway`** 🌉 — Unified entry point for all client requests.
*   **`ConfigServer`** ⚙️ — Centralized external configuration management.
*   **`UserService`** 👤 — Manages user profiles and orchestration.
*   **`RestaurantService`** 🍱 — Handles restaurant metadata.
*   **`RatingService`** ⭐ — Manages user-submitted reviews.

---

## 🛡️ Resilience & Fault Tolerance (Resilience4j)
We have implemented robust fault-handling mechanisms to ensure the system remains stable even if downstream services fail.

### 1. Circuit Breaker 🔌
- **Definition:** Prevents a cascading failure by "opening" the circuit when a service fails repeatedly. It stops calling the failing service and returns a **fallback response** immediately.
- **Example Scenario:** If the `RatingService` database is down, `UserService` won't hang waiting for a timeout. The Circuit Breaker trips after 5 failed calls, and all subsequent users get a "Dummy/Default User" response until the service recovers.
- **File:** `UserController.java` (implemented on `getSingleUser`)
- **Config:** `application.yml` under `resilience4j.circuitbreaker.instances.ratingHotelFallback`.

### 2. Retry Mechanism 🔄
- **Definition:** Automatically re-attempts a failed operation a specified number of times before either succeeding or triggering a fallback. Useful for handling "transient" errors (like a temporary network glitch).
- **Example Scenario:** If a service is momentarily restarting, the first request might fail. The Retry logic will wait 5 seconds and try again (up to 3 times) before giving up, ensuring the user often still gets their data without seeing an error.
- **File:** `UserController.java` (using `@Retry`)
- **Config:** `application.yml` under `resilience4j.retry.instances.ratingHotelService`.

---

## ⚙️ Centralized Configuration
We use **Spring Cloud Config Server** to manage configurations across all microservices from a single external source (Git).

- **Implementation:** `ConfigServer` service (Port: `8085`).
- **Client Usage:** Services like `UserService` import their config via `spring.config.import: optional:configserver:http://localhost:8085`.
- **Benefit:** Change configurations (like database URLs or feature flags) in one place without needing to rebuild or restart every microservice.

---

## 🗺️ API Endpoints Summary

### 👤 User Service (Port: 8081)
| Method | Full Endpoint URL | Description | Emoji |
| :--- | :--- | :--- | :---: |
| `POST` | `http://localhost:8081/users` | Create a new user account | 🆕 |
| `GET` | `http://localhost:8081/users` | Fetch list of all registered users | 👥 |
| `GET` | `http://localhost:8081/users/{userId}` | Retrieve details for a specific user | 👤 |

### 🍱 Restaurant Service (Port: 8082)
| Method | Full Endpoint URL | Description | Emoji |
| :--- | :--- | :--- | :---: |
| `POST` | `http://localhost:8082/restaurants` | Add a new restaurant to the system | 🏪 |
| `GET` | `http://localhost:8082/restaurants` | Fetch list of all available restaurants | 🍛 |
| `GET` | `http://localhost:8082/restaurants/{id}` | Get details for a single restaurant | 🍴 |
| `GET` | `http://localhost:8082/staff` | List staff members (internal) | 👨‍🍳 |

### ⭐ Rating Service (Port: 8083)
| Method | Full Endpoint URL | Description | Emoji |
| :--- | :--- | :--- | :---: |
| `POST` | `http://localhost:8083/ratings` | Submit a new user rating/review | ✍️ |
| `GET` | `http://localhost:8083/ratings` | Fetch all ratings from the database | 📊 |
| `GET` | `http://localhost:8083/ratings/users/{id}` | Get all ratings provided by a specific user | 🔍 |
| `GET` | `http://localhost:8083/ratings/restaurants/{id}`| Get all ratings for a specific restaurant | 🏢 |

---

## 🌎 API Gateway Access (Port: 8084)
The API Gateway serves as the single entrance to your ecosystem.

| Gateway Route 🛣️ | Destination Service |
| :--- | :--- |
| `GET/POST http://localhost:8084/users/**` | `UserService` |
| `GET/POST http://localhost:8084/restaurants/**` | `RestaurantService` |
| `GET/POST http://localhost:8084/ratings/**` | `RatingService` |

---

## 📋 Setup & Execution

### 🏃 Running the Services
Start the services in the following order:

1.  **Config Server** (`port: 8085`)
2.  **Service Registry** (`port: 8761`)
3.  **Core Services** (User, Restaurant, Rating)
4.  **API Gateway** (`port: 8084`)

```bash
# Example for starting a service
cd [ServiceFolder]/[ServiceFolder] && mvn spring-boot:run
```

---

## 🔮 Roadmap (Future Enhancements)
- [ ] **OAuth2/JWT:** Secure service communication.
- [ ] **Redis Caching:** Lightning-fast response times.
- [ ] **Dockerization:** Containerized deployment with Docker Compose.

---

<p align="center">
  <b>Built with ❤️ by CodeOverflow Team</b><br>
  <i>Scaling taste, one rating at a time.</i>
</p>
