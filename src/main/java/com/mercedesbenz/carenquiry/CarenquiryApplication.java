package com.mercedesbenz.carenquiry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import  javax.servlet.http.*;
/**
 * This package contains all the classes and interfaces related to the Car Enquiry API.
 * These classes include controllers, models, services, and exceptions.
 */
@SpringBootApplication
//@EnableSwagger2
public class CarenquiryApplication {
//entry point of the springboot application

	/**
	 *
	 * @param args This is used to run our springboot app
	 */
	public static void main(String[] args) {
		SpringApplication.run(CarenquiryApplication.class, args);
	}

}
