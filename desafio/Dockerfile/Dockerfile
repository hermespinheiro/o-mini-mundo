FROM openjdk:21-jdk-slim AS builder
WORKDIR /desafio

COPY pom.xml .
COPY src ./src

RUN apt-get update && apt-get install -y --no-install-recommends maven

RUN mvn clean package -DskipTests

FROM openjdk:21-slim AS runtime
WORKDIR /desafio
COPY --from=builder /desafio/target/desafio-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/desafio/app.jar"]