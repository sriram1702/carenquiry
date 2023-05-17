package com.mercedesbenz.carenquiry.swaggerconfig;

/**
 *  This package contains all the classes related to swagger configurations.
 */

import  io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.headers.Header;
import  io.swagger.v3.oas.annotations.info.Info;
import  io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.servers.Server;
//import org.springframework.stereotype.Component;
//import io.swagger.v3.oas.annotations.Components;
import org.springframework.stereotype.Component;
//import io.swagger.v3.oas.annotations.Components;
/**
 * This Class will have all the swagger configurations
 */




@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name="sriram",
                        email = "sriram.hariharan@mercedes-benz.com"

                ),
                description = "OpenApi documentation for Car Enquiry",
                title = "OpenApi specification-Sriram H",
                version = "1.0",
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "LOCAL ENV",
                        url = "http://localhost:8085"
                ),
                @Server(
                        description = "PROD ENV",
                        url = "http://localhost:8085"
                )

        }
)
/**
 * This class is used to configure our swaggerUI
 */
public  class SwaggerConfig {

}