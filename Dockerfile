FROM openjdk:8
ADD target/microservice-operation.jar microservice-operation.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "microservice-operation.jar"]