FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/kpt-0.0.1-SNAPSHOT.jar ./app.jar

ENV GOOGLE_ID=${GOOGLE_ID}
ENV GOOGLE_SECRET=${GOOGLE_SECRET}
ENV OPENAI_KEY=${OPENAI_KEY}

# Expose the port that your Spring Boot app listens on
EXPOSE 8081
CMD ["java", "-jar", "app.jar"]