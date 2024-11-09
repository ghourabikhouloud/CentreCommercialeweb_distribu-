#FROM maven:3.8.4-openjdk-11-slim AS build
FROM openjdk:17
EXPOSE 8102
ADD target/CentreCommercial-0.0.1-SNAPSHOT.jar CentreCommercial-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "CentreCommercial-0.0.1-SNAPSHOT.jar"]
