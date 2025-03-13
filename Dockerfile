# Use an OpenJDK base image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build files
COPY pom.xml .

# Copy the application source code
COPY src/ ./src/

# Build the application using Maven
RUN apt-get update && \
    apt-get install -y maven && \
    mvn clean package

# Set the port to expose
EXPOSE ${PORT}

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "target/restaurant.jar"]