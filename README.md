# IntelliQuiz 

Creating a REST API with Spring Boot for a Quiz Application.

IntelliQuiz is a web-based application that allows users to create, participate in, and manage quizzes. 
The application supports CRUD operations for quizes and questions, categorization, and quiz submission. It uses a RESTful API to handle requests and responses between the frontend and backend.


### Technologies/Tools used: </br>
Java 17 </br>
Spring Boot framework </br>
Hibernate </br>
PostgresSQL database </br>
Postman


## Features
Create and manage quizzes
CRUD operations on questions and quizzes
Fetch questions by category
Submit quiz answers


## Installation & Run
 - Before running the API server, we should update the database config inside the application.properties file.
 - Update the port number, username, and password as per our local database config.  
    - spring.application.name=IntelliQuiz
    - spring.datasource.driver-class-name=org.postgresql.Driver
    - spring.datasource.url=jdbc:postgresql://localhost:5432/questiondb
    - spring.datasource.username=postgres
    - spring.datasource.password=root
    - spring.jpa.hibernate.ddl-auto=update
    - spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

  
## API Endpoints

Question Management

- Retrieve All Questions

Endpoint: GET /question/allQuestions
Description: Fetches all the questions available in the database.

- Retrieve Questions by Category

Endpoint: GET /question/category/{category}
Description: Fetches questions based on a specific category.

- Add a Question

Endpoint: POST /question/add
Description: Allows adding a new question to the database.

- Delete a Question

Endpoint: DELETE /question/{id}
Description: Deletes a question based on its ID.

Quiz Management

- Create a Quiz

Endpoint: POST /quiz/create
Description: Creates a new quiz based on the specified category, number of questions, and title.

- Retrieve Quiz Questions

Endpoint: GET /quiz/get/{id}
Description: Fetches the questions for a specific quiz based on its ID.

- Submit a Quiz

Endpoint: POST /quiz/submit/{id}
Description: Submits answers for a quiz and calculates the result.
Request Body: List of SubmitResponse objects
Response: Quiz score
