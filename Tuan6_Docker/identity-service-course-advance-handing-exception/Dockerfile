# State 1: build
# Start with a Maven image that includes JDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Copy source code and pom.xml file to /app folder
WORKDIR /app
COPY pom.xml .
#RUN mvn dependency:go-offline
COPY src ./src

# Build source code with maven
RUN mvn package -DskipTests

# Start with Eclipse Termurin JDK 21
FROM eclipse-temurin:21-jdk

# Set working folder to App and copy complied file from above step
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]