FROM openjdk:11-jdk
ARG JAR_URL
EXPOSE 8089
ADD $JAR_URL amine-gestion-station-ski.jar
ENTRYPOINT ["java","-jar","/amine-gestion-station-ski.jar"]