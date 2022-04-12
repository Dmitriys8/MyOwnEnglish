FROM openjdk
COPY ../WEB/target/WEB-0.0.1-SNAPSHOT.jar /src/target/app.jar
WORKDIR /src/target
EXPOSE 8080
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","app.jar"]
