#FROM maven:3.8.4-openjdk-11-slim AS build
#RUN mvn clean install
FROM openjdk:17
EXPOSE 8761
ADD target/DiscoveryServer-0.0.1-SNAPSHOT.jar DiscoveryServer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "DiscoveryServer-0.0.1-SNAPSHOT.jar"]
