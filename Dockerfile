FROM maven:3.8.8-eclipse-temurin-17 AS builder
WORKDIR /workspace
COPY pom.xml .
COPY src/ src/
RUN mvn package -DskipTests -B

FROM amazoncorretto:17.0.8-alpine3.18
WORKDIR /app
COPY --from=builder /workspace/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
