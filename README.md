# Console University
## Description
This project is a simple realization of statistics app for University<br/>
The project is N-tier application with:
- DAO layer for interaction with DB
- Service layer with business logic
- Representation level for interaction with the app<br/>

## Commands
```
Command: Who is head of department {department_name}
Answer: Head of {department_name} department is {head_of_department_name}
```

```
Command: Who is head of department {department_name}
Answer: Head of {department_name} department is {head_of_department_name}
```
```
Command: Show {department_name} statistics.
Answer: 
assistans - {assistams_count}.
associate professors - {associate_professors_count}
professors -{professors_count}
```

```
Command: Show the average salary for the department {department_name}.
Answer: The average salary of {department_name} is {average_salary}
```
```
Command: Show count of employee for {department_name}.
Answer: {employee_count}
```
```
Command: Global search by {template}.   
Example: Global search by van
Answer: Ivan Petrenko, Petro Ivanov
```
## Technologies used
- Java 11
- Maven
- Spring Boot
- Hibernate
- H2 Database
- Lombok

## How to run locally
1. Fork and clone this project.
2. Run project in your IDE or go to the project root directory and run command `mvn -q spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=import"` in your terminal.
