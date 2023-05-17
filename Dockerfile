FROM openjdk:17
EXPOSE 8085
ADD target/car-enquiry.jar car-enquiry.jar
ENTRYPOINT ["java", "-jar", "/car-enquiry.jar"]
