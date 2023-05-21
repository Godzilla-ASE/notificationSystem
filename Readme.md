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

More details can be found in https://docs.google.com/spreadsheets/d/1nK-1bhyr9BWeO70jgLF9rlERT9HntIfBY5a4Xjk5ZaI/edit#gid=0  

2. The Message Service provides the following websocket endpoints: <br>
 
    Connection Endpoint: `/ase-websocket`
    Subscription Endpoint: `/topic/{userid}`

## Services Dependency

Notification service depends on user service, and mysql service.

## Testing and continuous integration
1. Testing



## Author

ASE Godzilla group : Manyi Wang
