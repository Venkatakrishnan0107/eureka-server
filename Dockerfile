FROM openjdk:8-jdk-slim
EXPOSE 8083
COPY apigateway-0.0.1-SNAPSHOT.jar apigateway.jar
ENTRYPOINT ["java", "-jar","/apigateway.jar"]


