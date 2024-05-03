# Use a base image with Java and Maven installed
FROM maven:3.8.4-openjdk-11-slim AS build

# Set working directory in the Docker image
WORKDIR /app

# Copy the Maven project files into the Docker image
COPY pom.xml .
COPY src ./src
COPY webdriver/chromedriver.exe /usr/local/bin/
COPY webdriver/geckodriver.exe /usr/local/bin/
COPY webdriver/msedgedriver.exe /usr/local/bin/


# Build the Selenium project
#RUN mvn clean package
# Use a smaller base image for the final Docker image
FROM openjdk:11-jre-slim

# Set working directory in the Docker image
WORKDIR /app

# Copy the compiled Selenium JAR file into the Docker image
COPY --from=build /app/target/smdockertest-0.0.1-SNAPSHOT.jar .
##COPY target/smdockertest-0.0.1-SNAPSHOT.jar /app/target/
##RUN chmod +r /app/target/smdockertest-0.0.1-SNAPSHOT.jar

# Specify the command to run your Selenium tests
CMD ["java", "-jar", "smdockertest-0.0.1-SNAPSHOT.jar"]