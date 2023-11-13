FROM openjdk:11
EXPOSE 8089
ADD ./target/amine-gestion-station-ski10.jar amine-gestion-station-ski10.jar
ENTRYPOINT ["java","-jar","/amine-gestion-station-ski10.jar"]