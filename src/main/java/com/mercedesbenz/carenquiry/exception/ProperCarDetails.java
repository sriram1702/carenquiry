package com.mercedesbenz.carenquiry.exception;

import java.io.Serializable;

/**
 * Exception to be thrown when the details of a car are not proper.
 *
 * <p>
 * This exception is thrown when a car's details are not proper, such as missing or invalid information. It extends the RuntimeException class,
 * so it is an unchecked exception that does not need to be declared in a method's throws clause. The exception message should provide details
 * about what is wrong with the car's details.
 * </p>
 *

 */
public class ProperCarDetails extends  RuntimeException {
    /**
     * Constructs a new ProperCarDetails exception with the specified detail message.
     *
     * @param message the detail message
     */
    public  ProperCarDetails(String message){
        super(message);
    }
}
