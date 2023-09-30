FROM maven:3.6.3-jdk-8
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
RUN mv target/attendance-0.0.1-SNAPSHOT.war attendance.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","attendance.war"]
