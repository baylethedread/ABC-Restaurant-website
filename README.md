# ABC Restaurant Web Application

## Project Overview

The **ABC Restaurant Web Application** is a database-driven web application designed for the `ABC Restaurant` chain. The system allows customers to make online reservations, search for hospitality services, submit queries, and check availability. Restaurant staff can manage reservations, respond to queries, and process payments through the website. The application is built using Java, JSP, Servlets, and MySQL, and it follows the MVC (Model-View-Controller) architecture.

## Features

- **Online Reservation:** Customers can make reservations for dining or delivery services.
- **Search Facilities:** Users can search for details regarding hospitality services and available facilities.
- **Submit Queries:** Customers can submit queries to the restaurant administration.
- **User Management:** Differential access rights for Admin, Restaurant Staff, and Customers.
- **Interactive User Interface:** User-friendly and responsive interfaces for all types of users.
- **Business Flow:** Clear implementation of the restaurant's business processes through the system.
- **Reports:** Customizable reports that add value to the business.

## Getting Started

### Prerequisites

- **Java JDK 8+**
- **Apache Tomcat 9**
- **MySQL Database**
- **Eclipse IDE** (or any other Java IDE)

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/your-username/ABC_Restaurant_WebApp.git
    cd ABC_Restaurant_WebApp
    ```

2. **Set up MySQL Database:**

    - Create a database named `ABC_RestaurantDB`.
    - Import the provided SQL schema to create necessary tables.

3. **Configure the Database Connection:**

    - Place the MySQL Connector/J JAR file in Tomcat's `lib` directory.
    - Configure the JNDI resource in `context.xml` or `web.xml` for `jdbc/ABC_RestaurantDB`.

4. **Deploy the Application:**

    - Build the project in your IDE.
    - Deploy the application on Apache Tomcat.
    - Access the application at `http://localhost:8080/ABC_Restaurant_WebApp`.

## Usage

- **Admin Panel:** Manage users, reservations, and queries.
- **Restaurant Staff:** View and manage customer reservations and queries.
- **Customer Portal:** Make reservations, submit queries, and search for services.

## Technologies Used

- **Java**: Backend logic.
- **JSP & Servlets**: Dynamic web pages and business logic.
- **MySQL**: Database management.
- **Tomcat**: Web server for deployment.
- **JNDI**: For managing database connections.

## Contributing

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/YourFeature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries, please contact `Eishan Kavinda Gamage` at `ekgago@gmail.com`.
