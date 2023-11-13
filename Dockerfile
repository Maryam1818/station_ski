FROM openjdk:11

EXPOSE 8089

ADD ./target/5ERP-BI6-gestion-station-ski.jar /app/app.jar

CMD ["java","-jar","/app/app.jar"]