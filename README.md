# Mini Bookstore Web Application

A multilingual Spring Boot bookstore application with user authentication, shopping cart, and order management.

## Features

- User Registration and Authentication
- Book Catalog Display
- Shopping Cart Management
- Order Processing
- Internationalization (English and French)
- H2 In-Memory Database
- Bootstrap UI

## Technologies

- Spring Boot 3.4.5
- Spring Security
- Spring Data JPA
- Thymeleaf
- H2 Database
- Bootstrap 5
- Maven

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Getting Started

1. Clone the repository:
   ```bash
   git clone  https://github.com/HickoDev/Book-Store-website
   cd bookstore
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the application:
   - Main application: http://localhost:8080
   - H2 Console: http://localhost:8080/h2-console
     - JDBC URL: jdbc:h2:mem:testdb
     - Username: sa
     - Password: (empty)

## Default Users

The application comes with two pre-configured users:

1. Admin User:
   - Email: admin@example.com
   - Password: password

2. Regular User:
   - Email: john@example.com
   - Password: password

## Internationalization

The application supports two languages:
- English (default)
- French

You can switch between languages using the language dropdown in the navigation bar.

## Project Structure

```
src/
└── main/
    ├── java/com/example/bookstore/
    │   ├── config/      (Spring Security Config)
    │   ├── controllers/ (Web Controllers)
    │   ├── models/      (Entity Classes)
    │   ├── repositories/(Data Repositories)
    │   └── services/    (Business Logic)
    └── resources/
        ├── templates/   (Thymeleaf Templates)
        ├── static/      (CSS/JS Assets)
        ├── messages_fr.properties
        ├── messages_en.properties
        └── application.properties
```

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request


