FROM openjdk:17
EXPOSE 8085
ADD target/car-enquiry-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/car-enquiry.jar"]
