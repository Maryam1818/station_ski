FROM openjdk:11
EXPOSE 8089
ADD ./target/amine-gestion-station-ski.jar amine-gestion-station-ski.jar
ENTRYPOINT ["java","-jar","/gestion-station-ski-1.0.jar"]