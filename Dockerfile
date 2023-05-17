FROM openjdk:17
EXPOSE 8085
ADD target/car-enquiry-0.0.1-SNAPSHOT.jar /app/car-enquiry.jar
ENTRYPOINT ["java", "-jar", "/app/car-enquiry.jar"]
