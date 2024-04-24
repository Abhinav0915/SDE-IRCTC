# AnakinSDE Application Documentation

Welcome to the AnakinSDE application documentation! AnakinSDE is a Spring Boot application designed to manage train schedules and ticket bookings. This documentation provides detailed information on how to use the application, including installation instructions, API endpoints, and more.

## Overview

The Train Booking System allows users to book train tickets and manage bookings. It provides APIs for creating users, authenticating users, adding trains, and booking tickets.

## Features

- User Management: Users can create accounts and login to the system.
- Train Management: Admins can add new trains to the system.
- Ticket Booking: Users can search for trains and book tickets for their desired route.

## Technologies Used

- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- JWT Authentication

## Prerequisites 
Before installing the AnakinSDE application, ensure you have the following prerequisites installed:

- Java Development Kit (JDK) 11 or later
- Apache Maven
- MySQL or another compatible relational database

## Getting Started

To run the application locally, follow these steps:

1. Clone the repository:

```bash
  https://github.com/Abhinav0915/SDE-IRCTC
```
2. Navigate to the project directory:

```bash
 cd SDE-IRCTC
```
3. Update the application.properties file with your MySQL database configuration.

```bash
 spring.datasource.url = jdbc:mysql://localhost:3306/your_database_name
 spring.datasource.username = your_sql_username
 spring.datasource.password = your_sql_password
```

4. Build the application:
```bash
 mvn clean install
```

5. Run the application


6. Access the application at http://localhost:8085.

## Tech Stack

- Java
- Springboot
- MySql

## API Endpoints

### Authentication

- POST /auth/login: Login to the system and obtain a JWT token.
- POST /auth/createUser: Create a new user account.
- GET /auth/users: See all registered users


### Train Management

- POST /trains/add: Add a new train to the system.
- POST /trains/between: Get a list of trains between two stations.

### Booking Management

- POST /bookings/book: Book a ticket for a specific train.

## Contributors

- Abhinav Saxena (@Abhinav0915)
