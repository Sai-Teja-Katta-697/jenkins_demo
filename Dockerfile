# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the build.gradle and settings.gradle files
COPY build.gradle settings.gradle /app/

# Copy the gradle wrapper and gradle directory
COPY gradlew /app/
COPY gradle /app/gradle

# Download the dependencies
RUN ./gradlew build --no-daemon || return 0

# Copy the project source
COPY . /app

# Build the application
RUN chmod +x gradlew && ./gradlew build --no-daemon || return 0

# Copy the jar file to the container
COPY build/libs/*.jar app.jar

# Expose the port the application runs on
EXPOSE 5000

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]