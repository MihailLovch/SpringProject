#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /target/SemesterProjectSpring-0.1.jar SemesterProjectSpring.jar
# ENV PORT=8080
EXPOSE 8181
ENTRYPOINT ["java","-jar","SemesterProjectSpring.jar"]