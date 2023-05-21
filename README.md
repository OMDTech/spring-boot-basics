# Basic Spring Boot Application

The Application shows how to build a simple CRUD application using Spring boot 3 and Docker 

## Requirements
- Java 17
- Docker for postgres database
- Maven 3.8.x

## Start the Application
- ``git clone https://github.com/OMDTech/spring-boot-basics.git``
- ``cd spring-boot-basics``
- ``docker compose up -d``
  - This command will run the docker-compose.file
  - **Note the docker must be running**
- ``mvn clean install``
- ```cd target```
- ```java -jar springboot-crash-course-0.0.1-SNAPSHOT.jar```
