# ABC Restaurant Web Application

## Overview

The **ABC Restaurant Web Application** is an interactive, database-driven platform developed for the **ABC Restaurant** chain, a popular restaurant group located across various cities in Sri Lanka. The application is designed to help the restaurant enhance its operations by providing a seamless web-based platform for managing reservations, customer queries, and facilitating services for different user types: **Admins**, **Staff**, and **Customers**.

This system enables the restaurant to move towards a more digital and user-friendly experience, offering features such as online reservations, service browsing, and direct interaction between the restaurant staff and customers.

## Key Features

### 1. **Home Page**
- Displays an overview of the restaurant's offerings, promotions, and services.
- Simple and intuitive navigation with links to key features like reservation, contact us, and product gallery.

### 2. **Product Gallery**
- A page showcasing a variety of dishes, promotions, and offers.
- Provides customers a glimpse of available menu items and special deals.

### 3. **About Us**
- Contains information about the history and mission of the restaurant.
- Provides details about the chain's presence across different cities and their vision for the future.

### 4. **Services We Offer**
- Displays the range of services offered by the restaurant such as dine-in, takeaway, and delivery.
- Customers can explore available options and make reservations accordingly.

### 5. **Contact Us**
- A form where users can submit queries and get in touch with the restaurant administration.
- Staff can view and respond to customer inquiries through the admin interface.

### 6. **Online Reservation**
- Customers can make reservations for dine-in, takeaway, or delivery services.
- Real-time reservation system connected to the database that stores booking details and provides availability information.

### 7. **Login and User Management**
- Unified login portal for **Admin**, **Restaurant Staff**, and **Customers**.
- Role-based access ensures users only see features relevant to them:
  - **Admin**: Manages users, configures system settings, and generates reports.
  - **Staff**: Manages reservations, processes payments, and responds to customer queries.
  - **Customer**: Makes reservations, submits queries, and tracks their service history.

## System Architecture

The application follows a multi-tiered architecture with a focus on modularity and maintainability:

- **Frontend**: The user interface is built with **HTML**, **CSS**, and **JSP** to provide a responsive and interactive experience.
- **Backend**: Developed using **Java Servlets** and **RESTful Web Services** to handle business logic, data transactions, and communication between the frontend and backend systems.
- **Database**: **MySQL** is used as the backend database to store all user, reservation, and query data, with structured relationships between entities.
- **Design Patterns**:
  - **MVC (Model-View-Controller)**: Separates the application's data, business logic, and presentation layers for better organization and code management.
  - **Singleton**: Manages database connections to ensure efficient resource handling.
  - **Factory Pattern**: Provides abstraction for object creation, enhancing scalability and modularity.

## Web Services

The application is built as a **distributed system** with multiple web services responsible for:

- **User Management**: Services for creating, updating, and deleting users.
- **Reservation Service**: Handles new reservations, checking availability, and reservation history.
- **Query Service**: Manages customer queries and staff responses.

These web services handle communication between the frontend and the backend, ensuring a smooth flow of data across the application.

## Database Design

The system uses a **MySQL** relational database, structured to handle:

- **Users**: Stores information for Admins, Staff, and Customers, including login credentials and roles.
- **Reservations**: Tracks all customer reservations for different services (dine-in, takeaway, delivery).
- **Queries**: Stores customer queries submitted via the website and records staff responses.

(Include a database diagram here that visually explains the relationships between entities such as Users, Reservations, Queries.)

## Screenshots

Here are some key screenshots that showcase the system’s interface and functionality:

| **Page**             | **Screenshot**                               |
|----------------------|----------------------------------------------|
| **Home Page**        | (![customer home](https://github.com/user-attachments/assets/45696e22-b52b-4425-a146-57e37895075e)
)              |
| **Product Gallery**  | (![product gallery](https://github.com/user-attachments/assets/f873501a-324b-4013-b71e-cece066096b5)
) |
| **Reservation Form** | (![make reservations and queries and view them](https://github.com/user-attachments/assets/466a2795-0cfe-49f7-9025-16069d5b41ba)
) |
| **Admin Dashboard**  | (![admin dashboard](https://github.com/user-attachments/assets/daaa2998-7dc4-4be1-89f2-cef804c6a073)
)   |
| **Login Page**       | (![login](https://github.com/user-attachments/assets/e614dfd8-bfcd-431a-a7d9-116f4996b2d6)
)        |

## Reports

The system also features several reports that add value to the business by providing useful insights: the admin has the ability to download a detailed report

# Project Installation Guide

This guide will help you set up and run the project on your local machine for development and testing purposes. The project uses **IntelliJ IDEA** as the IDE, **Java** for backend development, and **XAMPP** for managing the MySQL database.

## Prerequisites

Make sure you have the following tools installed:

1. **Java Development Kit (JDK)** (version 8 or above)
2. **IntelliJ IDEA** (Ultimate or Community Edition)
3. **XAMPP** (Apache + MySQL)
4. **Git** (optional but recommended for version control)

## Step 1: Clone the Repository

## Step 2: Import the Project into IntelliJ IDEA

1. Open **IntelliJ IDEA**.
2. Go to **File > Open** and select the cloned project folder.
3. IntelliJ will automatically detect the project structure and import it.
4. Set the **JDK** if required:
   - Go to **File > Project Structure > Project**.
   - Set the **Project SDK** to your installed JDK version.

## Step 3: Set Up XAMPP for MySQL

1. Start **XAMPP** and activate **Apache** and **MySQL**.
2. Open **phpMyAdmin** at [http://localhost/phpmyadmin](http://localhost/phpmyadmin).
3. Import the provided `.sql` file:
   - In **phpMyAdmin**, go to the **Import** tab.
   - Select the `.sql` file from your project folder and click **Go**.
5. Update database credentials in the project configuration 

## Step 4: Running the Project

Once the project is set up and the database is configured, you can run the application:

1. **Build the project**:
   - In IntelliJ, go to the top toolbar and click on the green **Run** button or press `Shift + F10` to build and run the application.
   
2. **Access the application**:
   - Once the application starts successfully, open a web browser.
   - Navigate to `http://localhost:8080` to access the application.

3. **Verify Database Connection**:
   - Ensure that your XAMPP server is running with **Apache** and **MySQL**.
   - Check that the application connects to the database by visiting different parts of the application (e.g., creating a user, making a reservation).

4. **Common Endpoints**:
   - Admin Dashboard: `http://localhost:8080/admin`
   - User Registration: `http://localhost:8080/register`
   - View Reservations: `http://localhost:8080/admin/reservation/api/reservations`

- **Reservation Reports**: Details on upcoming reservations sorted by date and service type.
- **Customer Interaction Reports**: Tracks customer activity such as the number of reservations made and queries submitted.
- **Financial Reports**: Summarizes payment details, including total earnings and transactions over time.


