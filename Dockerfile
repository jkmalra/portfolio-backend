# Use official Maven image to build the app
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy all files
COPY . .

# Build the JAR
RUN mvn clean package -DskipTests

# Run Phase
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the built JAR from previous stage
COPY --from=build /app/target/*.jar app.jar

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
