FROM openjdk:latest
EXPOSE 8080

ADD target/card-application.jar card-application.jar

ENTRYPOINT ["java" , "-jar" , "card-application.jar"]