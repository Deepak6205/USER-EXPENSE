
# <h1 align="center"> User Expense Tracker </h1>
___ 
<p align="center">
    <a href="Java url">
        <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
    </a>
    <a href="Maven url" >
        <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
    </a>
    <a href="Spring Boot url" >
        <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.4-brightgreen.svg" />
    </a>
  <a href="License url" >
        <img alt="BSD Clause 3" src="https://img.shields.io/badge/License-BSD_3--Clause-blue.svg"/>
    </a>
</p> <!-- Closing the first alignment paragraph -->

<p align="center"> <!-- Opening a new alignment paragraph for the last three URLs -->
    <a href="mySQL url" >
        <img alt="mySQL" src="https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white" />
    </a>
    <a href="Git Action url" >
        <img alt="Git Action" src="https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-badge&logo=githubactions&logoColor=white" />
    </a>
<a href="AWS url" >
    <img alt="AWS" src="https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white"/>
</a>
</p> <!-- Closing the second alignment paragraph -->

---

<p align="left">

## Overview

The User Expense Tracker is a Spring Boot-based system that empowers users to efficiently manage their expenses. It provides a set of RESTful API endpoints for creating and tracking expenses, categorizing transactions, and generating insightful reports.

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java
- **Database:** MySQL
- **Build Tool:** Maven
- **Database:** MySQL (Hosted on AWS EC2)
- **Continuous Integration:** GitHub Action
- **API Documentation:** SpringDoc OpenAPI (Swagger UI)

## AWS EC2 for Database

Our application utilizes an AWS EC2 instance to host the MySQL database. This instance is responsible for securely storing and managing user expense records and other related data. It allows for scalable and reliable database access while ensuring data security and performance.

## Continuous Integration with GitHub Actions

We have implemented a robust continuous integration (CI) workflow using GitHub Actions. With every code push to our repository, GitHub Actions automatically builds and tests our application to ensure code quality and reliability. This helps us maintain a stable and error-free application.

## Dependencies Used

The project leverages various dependencies to achieve its functionality:

- **Spring Boot Starter Data JPA**: Simplifies database access using Spring Data repositories.

- **Spring Boot Starter Web**: Provides support for building web applications, including RESTful APIs.

- **MySQL Connector/J (Runtime Dependency)**: The MySQL JDBC driver for connecting to MySQL databases.

- **Project Lombok (Optional)**: A library for reducing boilerplate code, such as getters and setters.

- **Spring Boot Starter Test (For Testing)**: Provides support for testing Spring Boot applications.

- **Springdoc OpenAPI (Swagger UI)**: Adds Swagger UI for documenting and testing API endpoints.

- **Thymeleaf (Optional)**: A templating engine used for generating dynamic HTML reports.

- **Other Dependencies:** Various other dependencies are included in the `pom.xml` file for specific functionalities, such as Jackson for JSON serialization, Spring Web for web-related features, and more.

For a comprehensive list of all dependencies and their versions, please refer to the project's `pom.xml` file.

## Project Structure

The project follows a structured and organized architecture:

- **Main Application Class:** The entry point for the application is defined in the main class.

- **Entities:** The application includes entities such as `Expense`, `Category`, and `User` to model the data.

- **Repository Interfaces:** Spring Data JPA repository interfaces manage data access.

- **Service Classes:** Business logic is implemented in service classes for managing expenses, categories, and users.

- **Controller Classes:** These classes define and document RESTful API endpoints for creating expenses, managing categories, and generating reports.

## Data Flow

The User Expense Tracker follows a structured data flow for tracking expenses, categorizing transactions, and generating reports:

1. **Expense Creation**:
    - A user creates an expense by sending a `POST` request to the `/api/expenses` endpoint, specifying the amount, description, and category.

    - The system saves the expense in the database, associating it with the user.

    - The system sends a response indicating successful expense creation.

2. **Expense Update and Deletion**:
    - Users can update or delete expenses by sending `PUT` or `DELETE` requests to the `/api/expenses/{expenseId}` endpoint, specifying the expense to update or delete.

    - The system checks if the provided expense exists and is associated with the user.

    - If the expense is valid, it is updated or deleted from the database.

    - The system sends a response confirming the update or deletion.

3. **Category Management**:
    - Users can create and manage expense categories through API endpoints, such as creating a new category with a `POST` request to `/api/categories`.

    - The system manages expense categories and associations with expenses.

4. **Expense Reporting**:
    - Users can generate expense reports by sending a `GET` request to the `/api/reports` endpoint.

    - The system retrieves and analyzes user expenses to generate insightful reports, such as monthly and category-based reports.

5. **Security**:
    - User authentication and authorization are handled securely, ensuring that user data is protected and that only authorized users can access and manage their expenses.

6. **Data Persistence**:
    - The application relies on a relational database for data storage. Entities like expenses, categories, and users are mapped to the corresponding database tables.

7. **RESTful API Endpoints**:
    - RESTful API endpoints provide a clear interface for users to create expenses, manage categories, and generate expense reports. These endpoints are documented using Swagger UI.

> This data flow illustrates how users can interact with the application, track expenses, manage categories, and gain insights through expense reports.

## RESTful API Endpoints

The application provides RESTful API endpoints for various functionalities:

### Expense Management

- **Create Expense:** `POST /api/expenses`
- **Update Expense:** `PUT /api/expenses/{expenseId}`
- **Delete Expense:** `DELETE /api/expenses/{expenseId}`

### Category Management

- **Create Category:** `POST /api/categories`
- **Update Category:** `PUT /api/categories/{categoryId}`
- **Delete Category:** `DELETE /api/categories/{categoryId}`

### Expense Reporting

- **Generate Reports:** `GET /api/reports`

The API endpoints are documented, adhering to REST principles, and provide the core features of the User Expense Tracker.

## Database Design

The application uses a relational database to store data, including user information, expenses, categories, and transactions. Key attributes and tables include:

### User Table

| Column Name | Data Type    | Description                 |
| ----------- | ------------ | --------------------------- |
| userId      | INT          | Unique identifier for users |
| username    | VARCHAR(255) | User's username             |
| password    | VARCHAR(255) | Encrypted user password     |
| expenses    | One-to-Many  | Expenses associated with the user |

### Expense Table

| Column Name | Data Type    | Description                 |
| ----------- | ------------ | --------------------------- |
| expenseId   | INT          | Unique identifier for expenses |
| amount      | DECIMAL(10, 2) | Expense amount             |
| description | VARCHAR(255) | Description of the expense |
| date        | DATE         | Date of the expense         |
| category_category_id | INT | Foreign key referencing the expense category |
| user_user_id | INT       | Foreign key referencing the user |

### Category Table

| Column Name | Data Type    | Description                 |
| ----------- | ------------ | --------------------------- |
| categoryId  | INT          | Unique identifier for categories |
| name        | VARCHAR(255) | Category name               |
| expenses    | One-to-Many  | Expenses associated with the category |

### Transaction Table

| Column Name | Data Type    | Description                 |
| ----------- | ------------ | --------------------------- |
| transactionId | INT       |

 Unique identifier for transactions |
| description | VARCHAR(255) | Description of the transaction |
| amount      | DECIMAL(10, 2) | Transaction amount         |
| date        | DATE         | Date of the transaction     |
| category_category_id | INT | Foreign key referencing the transaction category |
| user_user_id | INT       | Foreign key referencing the user |

### AuthenticationToken Table

| Column Name     | Data Type    | Description               |
| --------------- | ------------ | ------------------------- |
| tokenId          | INT          | Unique identifier for tokens |
| token           | VARCHAR(255) | Authentication token value |
| tokenCreationDate | DATE    | Date of token creation     |
| user_user_id    | INT        | Foreign key referencing the user |

### User Table Description

- `userId`: Unique identifier for each user.
- `username`: User's unique username.
- `password`: Encrypted password for user authentication.
- `expenses`: A collection of expenses associated with the user.

### Expense Table Description

- `expenseId`: Unique identifier for each expense.
- `amount`: The amount of the expense.
- `description`: Description of the expense.
- `date`: Date of the expense.
- `category`: A reference to the associated category.
- `user`: A reference to the user who created the expense.

### Category Table Description

- `categoryId`: Unique identifier for each category.
- `name`: Name of the category.
- `expenses`: A collection of expenses associated with the category.

### Transaction Table Description

- `transactionId`: Unique identifier for each transaction.
- `description`: Description of the transaction.
- `amount`: Amount of the transaction.
- `date`: Date of the transaction.
- `category`: A reference to the associated category.
- `user`: A reference to the user associated with the transaction.

### AuthenticationToken Table Description

- `tokenId`: Unique identifier for each token.
- `token`: A unique token for user authentication.
- `tokenCreationDate`: The date when the token was created.
- `user`: A reference to the associated user for whom the token is issued.

## Data Structures Used

1. **Entities**:
    - **User**: Represents a user with attributes like `userId`, `username`, `password`, and a collection of `expenses`.

    - **Expense**: Represents an expense with attributes like `expenseId`, `amount`, `description`, `date`, a reference to the associated `category`, and a reference to the user who created the expense.

    - **Category**: Represents a category for organizing expenses with attributes like `categoryId`, `name`, and a collection of `expenses`.

    - **Transaction**: Represents a transaction with attributes like `transactionId`, `description`, `amount`, `date`, a reference to the associated `category`, and a reference to the user associated with the transaction.

    - **AuthenticationToken**: Represents an authentication token with attributes like `tokenId`, `token`, `tokenCreationDate`, and a reference to the associated user.

2. **Repositories**:
    - JPA repositories for data access, including repositories for users, expenses, categories, transactions, and authentication tokens.

3. **ArrayLists**:
    - ArrayLists are used for efficiently managing lists of entities. For example, a user's expenses are managed using a collection of `Expense` entities within the `User` entity.

> ArrayLists provide flexibility for storing and managing multiple entities efficiently within the application. The actual storage and retrieval of data are typically handled by the JPA repositories and the underlying database systems.

## Database Configuration

The database connection properties, including the URL, username, and password, are specified in the `application.properties` file. Ensure that these properties are correctly configured to connect to your MySQL database.

Example configuration for MySQL:

```properties
spring.datasource.url=jdbc:mysql://<Public IP>:3306/ExpenseTracker
spring.datasource.username=root
spring.datasource.password=yourPassword
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

Please replace `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` with your database connection details.

## Project Summary

The User Expense Tracker is a Spring Boot-based system that simplifies expense tracking, management, and reporting. It provides RESTful API endpoints for creating and tracking expenses, managing categories, and generating insightful reports.

The application is built on a solid foundation, utilizing Spring Boot and MySQL for data storage, and it follows best practices for clean code, separation of concerns, and secure user data handling.

### License

This project is licensed under the [BSD 3-Clause License](LICENSE).

### Acknowledgments

We would like to thank the Spring Boot and Java communities for providing excellent tools, frameworks, and resources that have contributed to the development of this project.

### Contact

For questions or feedback, please contact [Deepak Kumar](mailto:business.deepak7292832956@gmail.com).

# week-User-Expense
# USER-EXPENSE
