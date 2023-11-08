FROM openjdk:11
EXPOSE 8089
ADD ./target/Amine-gestion-station-ski.jar Amine-gestion-station-ski.jar
ENTRYPOINT ["java","-jar","/Amine-gestion-station-ski.jar"]