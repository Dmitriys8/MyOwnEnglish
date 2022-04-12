# MyOwnEnglish

## Description

_TODO_

---
## How to run


### 1. Run using docker only
Move to the project directory
```
cd <path_to_the_folder_where_you_have_the_project>/MyOwnEnglish/
```
and build it with maven
```
./mvnw clean install
```
then move to docker directory
```
cd docker
```
and run docker-compose
```
docker-compose up -d [--build]
```
---
### 2. Run application locally 
Move to the docker directory
```
cd <path_to_the_folder_where_you_have_the_project>/MyOwnEnglish/docker
```
edit docker-compose.yaml file consider instructions inside (comment declaration of tenses-msvc)

then run docker-compose
```
docker-compose up -d
```
move back one level higher
```
cd ..
```
build the project with maven
```
./mvnw clean install
``` 
and run java application
```
java -jar WEB/target/WEB-0.0.1-SNAPSHOT.jar
```
> Swagger is available  on http://localhost:8080/api/swagger-ui/index.html 