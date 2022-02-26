FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine-slim
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
