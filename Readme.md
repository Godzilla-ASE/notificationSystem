# Notification System

Notification Service is a backend service that handles notification and messages. 
Functions include:
- Create messages / send notification to clients
- Delete messages
- Get messages through user id

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven

## Configuration

1. Open the `application.properties` file in the `src/main/resources` directory.
2. Provide the necessary configuration values, such as database connection details.
 -  spring.datasource.url: Specifies the URL for the MySQL database connection.
  - spring.datasource.username and spring.datasource.password: Provide the username and password for the database connection.
 - spring.jpa.properties.hibernate.dialect: Sets the Hibernate dialect for MySQL.
 - spring.jpa.hibernate.ddl-auto: Determines how Hibernate handles the database schema updates. The update value indicates that Hibernate will automatically update the schema based on the entity mappings.
  - server.port: Specifies the port on which the application will run locally.
  - Please ensure that you have a MySQL database running with the specified connection details before running the application.

## Usage

1. Start the User Service  
- without docker:

```bash
./mvnw spring-boot:run
```

- with docker:

```bash
docker run hanyang11/asenotifyimg:v1.0
```

2. The service will be accessible at `http://localhost:8083`.

## API Endpoints

1. The Message Service provides the following HTTP endpoints:  

- `GET /notification/{userid}`: Get messages through user id.
- `POST /notification`: Create messages.
- `POST /botification/delete`: Delete messages

More details can be found in `API_documentation.xlsx` 

2. The Message Service provides the following websocket endpoints: <br>
 
    Connection Endpoint: `/ase-websocket`
    Subscription Endpoint: `/topic/{userid}`

## Services Dependency

Notification service depends on user service, and mysql service.

## Testing and continuous integration
1. Testing

- unit testing to test methods
- Postman to test endpoints

2. Continuous integration
- Sonarcube

## Author

ASE Godzilla group : Manyi Wang
