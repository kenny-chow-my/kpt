# Use a base image with Java and Maven pre-installed
FROM maven:3-amazoncorretto-17 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the project's pom.xml and other necessary files to the container
COPY pom.xml .
COPY src ./src

# Build the project using Maven
RUN mvn clean install

# Use a lightweight JRE base image to run the application
FROM amazoncorretto:17-alpine-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the builder stage to the final image
COPY --from=builder /app/target/kpt-0.0.1-SNAPSHOT.jar ./app.jar

ENV GOOGLE_ID=${GOOGLE_ID}
ENV GOOGLE_SECRET=${GOOGLE_SECRET}
ENV OPENAI_KEY=${OPENAI_KEY}

# Expose the application's port (if needed)
EXPOSE 8081

# Command to run the application when the container starts
CMD ["java", "-jar", "app.jar"]