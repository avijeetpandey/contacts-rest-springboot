# Use a lightweight JDK 25 base image (adjust to your Java version)
FROM eclipse-temurin:25-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the packaged JAR file into the container
# (Make sure to build your project using 'mvn clean package' first)
COPY target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]