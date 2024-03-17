FROM openjdk:17
ARG JAR_FILE=./targer/corporate_settlement_service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /app/app.jar
EXPOSE 8080