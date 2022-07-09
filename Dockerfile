FROM openjdk:8-jdk-slim
EXPOSE 8761
COPY eurekams-0.0.1-SNAPSHOT.jar eureka-server.jar
ENTRYPOINT ["java", "-jar","/eureka-server.jar"]


