FROM openjdk:11
EXPOSE 8080
ADD target/gui-video1.jar gui-video1.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
