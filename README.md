
# Spring Boot User Management API

This is a simple Spring Boot application that provides a RESTful API for managing users. The API supports CRUD operations (Create, Read, Update, Delete) for managing a list of users.

## Features

- **Create**: Add new users.
- **Read**: Retrieve a list of all users or get a user by their ID.
- **Update**: Modify the details of an existing user by their ID.
- **Delete**: Remove a user by their ID.

The users are stored in memory (using an `ArrayList`), so the data is reset every time the application restarts.

## Endpoints

1. **GET /users**  
   Returns a list of all users.

   **Response**:
   ```json
   [
     {
       "id": 1,
       "name": "A",
       "age": 37,
       "email": "a@email.com"
     },
     ...
   ]
   ```

2. **GET /users/{id}**  
   Retrieves a user by their ID.

   **Response** (User exists):
   ```json
   {
     "id": 1,
     "name": "A",
     "age": 37,
     "email": "a@email.com"
   }
   ```

   **Response** (User not found):
   ```json
   {
     "message": "User not found with ID: 1"
   }
   ```

3. **POST /users**  
   Adds a new user. You must provide a JSON body containing the user's details.

   **Request Body**:
   ```json
   {
     "id": 6,
     "name": "F",
     "age": 29,
     "email": "f@email.com"
   }
   ```

   **Response** (User added successfully):
   ```json
   {
     "id": 6,
     "name": "F",
     "age": 29,
     "email": "f@email.com"
   }
   ```

   **Response** (User already exists):
   ```json
   {
     "message": "User with ID 6 already exists."
   }
   ```

4. **PUT /users/{id}**  
   Updates an existing user by their ID.

   **Request Body**:
   ```json
   {
     "name": "Updated Name",
     "age": 35,
     "email": "updated@email.com"
   }
   ```

   **Response** (User updated):
   ```json
   {
     "id": 1,
     "name": "Updated Name",
     "age": 35,
     "email": "updated@email.com"
   }
   ```

   **Response** (User not found):
   ```json
   {
     "message": "User not found with ID: 1"
   }
   ```

5. **DELETE /users/{id}**  
   Deletes a user by their ID.

   **Response** (User deleted):
   ```json
   {
     "message": "User with ID: 1 deleted successfully."
   }
   ```

   **Response** (User not found):
   ```json
   {
     "message": "User not found with ID: 1"
   }
   ```

## Technologies Used

- **Spring Boot**: For creating the RESTful API.
- **Java**: The main programming language.
- **Maven**: For dependency management and building the project.

## Setup and Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/spring-boot-user-api.git
   ```

2. **Navigate to the project directory**:
   ```bash
   cd spring-boot-user-api
   ```

3. **Build and run the application**:
   You can build and run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the API**:  
   Once the application is running, the API will be available at `http://localhost:8080`.

## Error Handling

- **User already exists**: When trying to add a user with an ID that already exists, a `400 Bad Request` error will be returned.
- **User not found**: If a user is not found when retrieving, updating, or deleting by ID, a `404 Not Found` error will be returned.
  
## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.