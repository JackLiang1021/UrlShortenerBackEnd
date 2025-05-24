# Use OpenJDK base image
FROM openjdk:24-jdk

# Set working directory
WORKDIR /app

# Copy the built JAR into the container
COPY target/urlshortener-0.0.1-SNAPSHOT.jar app.jar

# Expose port your Spring Boot app runs on (default is 8080)
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
