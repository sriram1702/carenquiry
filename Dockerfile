FROM openjdk:17
EXPOSE 8085
COPY build/libs/car-enquiry-0.0.1-SNAPSHOT.jar /car-enquiry.jar
ENTRYPOINT ["java", "-jar", "/car-enquiry.jar"]
