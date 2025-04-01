# Stage 1: Build the application
FROM adoptopenjdk/openjdk11:latest AS build
WORKDIR /workspace

# Copy necessary files
COPY build.gradle.kts settings.gradle.kts gradlew /workspace/
COPY gradle /workspace/gradle
COPY src /workspace/src

# Ensure permissions for the Gradle wrapper
RUN chmod +x gradlew
RUN ./gradlew build --no-daemon

# Stage 2: Create a minimal runtime image
FROM adoptopenjdk/openjdk11:latest
WORKDIR /app

# Copy the generated JAR file from the build stage
COPY --from=build /workspace/build/libs/*.jar app.jar

# Expose the correct application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
