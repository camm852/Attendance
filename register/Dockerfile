FROM maven:3.6.3-jdk-8 AS MAVEN_BUILD
RUN mkdir /app
COPY ./ /app
RUN echo "Building app..." && cd /app && mvn clean package -DskipTests

FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=MAVEN_BUILD /app/target/register-0.0.1-SNAPSHOT.war /app/register.war
EXPOSE 8080
CMD ["java", "-jar", "register.war"]