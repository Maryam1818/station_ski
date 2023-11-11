FROM openjdk:11

EXPOSE 8089
ADD ./target/5ERP-BI6-gestion-station-ski.jar 5ERP-BI6-gestion-station-ski.jar

ENTRYPOINT ["java","-jar","/gestion-station-ski-1.0.jar"]