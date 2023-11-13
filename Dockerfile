FROM openjdk:11
EXPOSE 8089
ADD ./target/amine-gestion-station-ski.jar amine-gestion-station-ski.jar
ENTRYPOINT ["java","-jar","/amine-gestion-station-ski.jar"]