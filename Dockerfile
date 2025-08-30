# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for better caching)
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Make mvnw executable
RUN chmod +x ./mvnw

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Find and copy the jar file to a known location
RUN cp target/*.jar app.jar

# Expose the port that Render will use
EXPOSE $PORT

# Run the jar file
CMD ["java", "-jar", "app.jar"]