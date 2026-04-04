# Restaurant User Rating Backend (Microservices)

## Objective
This project is a backend system for a Restaurant User Rating application, built using a microservices architecture. It allows users to view restaurants, submit ratings and reviews, and manages user information. The system is designed to be highly scalable and modular, dividing responsibilities into distinct independent services that communicate with each other.

By leveraging microservices, the application isolates failures, scales components independently, and serves as a solid foundation for distributed system patterns.

## Tech Stack
* **Java 17** 
* **Spring Boot 3.0.x**
* **Spring Cloud** (Netflix Eureka for Service Discovery)
* **Spring Data JPA** (Hibernate)
* **Spring Data MongoDB**
* **Lombok** (Boilerplate reduction)
* **Maven** (Build Tool)

## Databases Used
The project utilizes polyglot persistence to align databases with each service's specific requirements:
* **PostgreSQL:** Used for the `UserService`.
* **MySQL:** Used for the `RestaurantService`.
* **MongoDB:** Used for the `RatingService`.

Make sure you have PostgreSQL, MySQL, and MongoDB running locally with the appropriate databases created (`microservice` for Postgres, `microservices` for MySQL) as configured in the `src/main/resources/application.yml` files.

## Project Structure
The workspace includes four standalone services (each is a Maven project):
* `ServiceRegstry` — Service discovery server (Netflix Eureka).
* `RestaurantServive` — Manages restaurant data and business logic.
* `RatingService` — Manages ratings and reviews for restaurants.
* `UserService` — Manages user data.

## Compile and Run Steps

### Prerequisites
* JDK 17 or higher installed.
* Maven installed (or you can use the provided Maven wrappers `mvnw`).
* PostgreSQL, MySQL, and MongoDB installed and running locally. Ensure the necessary databases are created.
* Update credentials (username/password) in the respective `application.yml` files if they differ from the local database configurations.

### Compilation
You can compile all services using Maven. Navigate to each service's source directory and build the project:

```bash
# Example for UserService
cd UserService/UserService
mvn clean install -DskipTests
```

### Running the Application (Locally)
The services must be started in a specific order to ensure they register correctly with the Service Registry.

#### 1. Start Service Registry
Open a terminal, navigate to the `ServiceRegstry` directory, and start it:
```bash
cd ServiceRegstry/ServiceRegstry
mvn spring-boot:run
```
*Wait for Eureka to start and initialize completely (default accessible on port 8761).*

#### 2. Start Other Services
Open separate terminals for each of the following services and start them:

**User Service:**
```bash
cd UserService/UserService
mvn spring-boot:run
```

**Restaurant Service:**
```bash
cd RestaurantServive/RestaurantServive
mvn spring-boot:run
```

**Rating Service:**
```bash
cd RatingService/RatingService
mvn spring-boot:run
```

*(Note: They can be started in any order after the Service Registry is active).*

### IDE (IntelliJ/Eclipse) Execution
Alternatively, you can import the individual service folders (`ServiceRegstry/ServiceRegstry`, etc.) as separate Maven projects into your IDE and run their respective `*Application.java` main classes directly.

## Pending Features (Roadmap)
The following components and features are currently planned and will be added in future iterations:
- **Config Server:** To centralize external configuration management across all microservices.
- **OAuth Security:** To secure endpoints using modern authentication and authorization logic workflows.
- **API Gateway:** To provide a single unified entry point for all clients and efficiently route requests to the appropriate back-end microservices.
- **Caching:** Distributed caching mechanisms (e.g., Redis) to drastically improve response times and reduce database read loads.
