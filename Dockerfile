FROM maven:3.8.2-jdk-8
ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} gestion-station-ski-1.0.0.jar
ENTRYPOINT ["java", "-jar" ,"/gestion-station-ski-1.0.0.jar"]
EXPOSE 8089