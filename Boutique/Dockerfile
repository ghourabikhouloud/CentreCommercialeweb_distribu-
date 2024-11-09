#FROM maven:3.8.4-openjdk-11-slim AS build
FROM openjdk:17
#EXPOSE 8107
EXPOSE 8101
ADD target/Boutique-0.0.1-SNAPSHOT.jar Boutique-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "Boutique-0.0.1-SNAPSHOT.jar"]
