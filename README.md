# Elective Class Todo API

A simple Spring Boot REST API for managing todos.

## Requirements

- Java 21
- Maven wrapper included in the project

## Run

```bash
./mvnw spring-boot:run
```

The app runs on:

```text
http://localhost:8085
```

## Swagger Docs

```text
http://localhost:8085/swagger-ui.html
```

OpenAPI JSON:

```text
http://localhost:8085/v3/api-docs
```

## API

Base path:

```text
/api/v1/todos
```

Main endpoints:

- `POST /api/v1/todos`
- `GET /api/v1/todos`
- `GET /api/v1/todos/{id}`
- `PUT /api/v1/todos/{id}`
- `PATCH /api/v1/todos/{id}/complete`
- `DELETE /api/v1/todos/{id}`

## Build

```bash
./mvnw -q -DskipTests compile
```
