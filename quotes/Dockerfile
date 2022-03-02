FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine-slim
COPY target/quotes-1.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]