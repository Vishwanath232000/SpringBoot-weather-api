# **Weather Details REST API**

This project is a REST API built using Spring Boot that manages weather details for various cities. It allows users to create, retrieve, update, and delete weather records.

## **Features**:
Create new weather details for cities.
Retrieve a list of all cities' weather details or fetch weather details for a specific city by name.
Update existing weather details for a city.
Delete weather records by city ID or city name.
Unit Tests implemented for controller, repository, and service layers to ensure reliability.
Technologies Used
Java
Spring Boot
Spring Data JPA
Hibernate
H2 Database (for testing)
Maven
Getting Started
Prerequisites
Java 11 or later
Maven
IDE (e.g., IntelliJ IDEA, Eclipse)

### **Installation**:

Clone the repository:
bash
Copy code
git clone <your-repo-url>
cd <your-repo-name>

### **Build the project using Maven**:

bash
Copy code
mvn clean install

### **Run the application**:

bash
Copy code
mvn spring-boot:run

### **API Endpoints**:
Method	Endpoint	Description
POST	:/cities	Create a new weather record.
GET	: /cities	Retrieve all weather records.
GET	: /cities/{city}	Fetch weather details by city name.
PUT	: /cities/{id}	Update weather details for a city.
DELETE :	/cities/id/{id}	Delete weather record by city ID.
DELETE :	/cities/name/{cityName}	Delete weather record by city name.

### **Unit Tests**:
Unit tests have been implemented for the controller, repository, and service layers to ensure each component works as expected. Run the following command to execute the tests:

bash
Copy code
mvn test
