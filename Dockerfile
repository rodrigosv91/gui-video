FROM gradle:8.0.2-jdk11
COPY build/libs/dbrank-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/app.jar"]
