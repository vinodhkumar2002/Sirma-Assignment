Project Management System API

Welcome to the Project Management System API documentation. This API allows you to manage projects using CRUD (Create, Read, Update, Delete) operations.

Setup Instructions:

Prerequisites:
- Java 17
- Maven

Steps:
1. Clone the repository:
   git clone https://github.com/vinodhkumar2002/Sirma-Assignment1.git

2. Navigate to the project directory:
   cd project-management-system

3. Build the project using Maven:
   mvn clean install

4. Run the application:
   mvn spring-boot:run

API Endpoints:

Create a new project:
- URL: /project
- Method: POST
- Request Body:
  {
    "name": "Project Name",
    "description": "Project Description",
    "startDate": "2024-04-27",
    "endDate": "2024-05-27"
  }

Get all projects:
- URL: /project
- Method: GET

Get a project by ID:
- URL: /project/{id}
- Method: GET

Update a project:
- URL: /project/{id}
- Method: PUT
- Request Body:
  {
    "name": "Updated Project Name",
    "description": "Updated Project Description",
    "startDate": "2024-04-27",
    "endDate": "2024-05-27"
  }

Delete a project:
- URL: /project/{id}
- Method: DELETE

Technologies Used:
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Swagger
