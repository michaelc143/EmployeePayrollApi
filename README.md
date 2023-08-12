# Basic API for an employee payroll application using in memory database written in Spring Boot

- To start the API, run the following command:

```bash
./mvnw clean spring-boot:run
```

- This application also contains a dockerfile for containerization. To build the docker image, run the following command from the root directory:

```bash
docker build -t payrollapi .
```

- To run that docker image as a container locally, run the following command from the root directory:

```bash
docker run -p 8080:8080 payrollapi
```
