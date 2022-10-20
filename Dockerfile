FROM eclipse-temurin:17
WORKDIR app
COPY target/*.jar java-mcr-exam.jar
ENTRYPOINT ["java", "-jar", "java-mcr-exam.jar"]