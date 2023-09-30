FROM maven:3.6.3-jdk-8
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
COPY target/register-0.0.1-SNAPSHOT.war register.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","register.war"]

# FROM maven:3.8.1-openjdk-17-slim AS MAVEN_BUILD

# RUN mkdir /app
# COPY ./ /app

# RUN echo "Building app..." && cd /app && mvn clean package -DskipTests

# FROM openjdk:17-oracle

# WORKDIR /app
# COPY --from=MAVEN_BUILD /app/target/register-0.0.1-SNAPSHOT.war /app/register.war
# EXPOSE 8080

# CMD ["java", "-jar", "register.war"]