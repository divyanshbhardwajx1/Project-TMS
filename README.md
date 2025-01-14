# Smart Traffic Management System

Welcome to the **Smart Traffic Management System** project! This system leverages modern web technologies to monitor and manage traffic efficiently, ensuring smooth flow and reducing congestion in urban areas. The application is built using Spring Boot with Maven and offers RESTful APIs for seamless integration and interaction.

---

## 🌟 Introduction
Traffic management is a critical issue in today's fast-growing cities. This **Smart Traffic Management System** aims to provide an intelligent solution to monitor, control, and manage traffic data effectively. By utilizing this system, authorities can take real-time decisions to mitigate traffic jams and improve road safety.

---

## ✨ Features
- **Real-Time Traffic Monitoring:** Fetch and manage traffic data efficiently.
- **RESTful APIs:** Easy integration with other systems or mobile apps.
- **Robust Error Handling:** Ensures application stability with meaningful error messages.
- **Input Validation:** Validates
 data to ensure system reliability.
- **Logging and Debugging:** Captures critical application logs for better debugging.

---

## 🛠️ Technology Used
- **Backend:** Spring Boot (Java)
- **Build Tool:** Maven
- **Validation:** Spring Boot Validation
- **Logging:** SLF4J
- **Database:** H2 (In-Memory Database)
- **Testing Framework:** JUnit

--------------------------------------
#PROJECT STRUCTURE

smart-traffic-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/
│   │   │       └── smarttraffic/
│   │   │           ├── controller/                # Controllers for handling API requests
│   │   │           │   └── TrafficController.java
│   │   │           ├── dao/                       # Data Transfer Objects
│   │   │           │   └── TrafficDao.java
│   │   │           ├── exception/                 # Exception handling classes
│   │   │           │   ├── GlobalExceptionHandler.java
│   │   │           │   └── ResourceNotFoundException.java
│   │   │           ├── model/                     # Entity classes representing the database tables
│   │   │           │   └── TrafficData.java
│   │   │           ├── repository/                # Interfaces for database interactions
│   │   │           │   └── TrafficDataRepository.java
│   │   │           ├── service/                   # Business logic
│   │   │           │   └── TrafficService.java
│   │   │           └── servlet/
                         |__UserProfileServlet.java
                         |__UserRegistrationServlet.java
│   │   └── resources/
            
│   │    ├── application.properties                   # Application configuration
│   │       ├── application.yml              
│   └── test/
│       └── java/
│           └── com/example
│               └── smarttraffic/controller
│                   └── TrafficControllerTest.java # Unit tests for TrafficController
                        /dao--TrafficDaoTest.java
                        /model-TrafficDetails.java
                               TrafficSignalTest.java
                        /service--TrafficService.java
                                   TrafficServiceTest.java

├── pom.xml                                        # Maven dependencies and build configuration
├── README.md                                      # Project documentation
└── LICENSE                                        # License for the project


## 🚀 How to Set Up and Run the Project

### Prerequisites
1. Install **Java 17** or higher.
2. Install **Maven 3.8** or higher.

### Steps to Run
1. **Clone the repository**:
   ```bash
   git clone <repository-link>
   cd smart-traffic-management-system
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```
   

4. Access the application at:
   ```
   http://localhost:8080
   ```
