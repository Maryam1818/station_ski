FROM maven:3.8.4-openjdk-11


COPY settings.xml /root/.m2/settings.xml

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN mvn dependency:resolve

COPY src ./src

CMD ["mvn", "spring-boot:run"]
