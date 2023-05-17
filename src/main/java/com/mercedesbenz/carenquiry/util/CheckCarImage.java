/**
 * This package contains utility classes and methods that are used throughout the
 * Mercedes-Benz Car Enquiry application. These classes and methods are not specific to
 * any particular feature or module, but rather provide generic functionality that can be
 * used across the application.
 *
 * <p>Some examples of utility classes in this package include {@link CheckCarImage},
 * {@link CheckCarName}, and {@link CheckCarPrice}, which provide methods for checking
 * the validity of car image URLs, car names, and car prices, respectively.
 *
 * <p>Other utility classes in this package include {@link DateUtils}, which provides
 * methods for working with dates and times, and {@link StringUtils}, which provides
 * methods for working with strings.
 *
 * @since 1.0
 */
/**
 * This package contains utility classes and helper methods used by the Car Enquiry system.
 */
package com.mercedesbenz.carenquiry.util;


/**
 * This class is responsible for checking if a given car image URL is valid or not.
 * It contains a single static method {@code ToCheckCarImage} that takes a car image URL
 * as a string and returns a boolean value indicating whether the URL is valid or not.
 *
 * <p>The method returns {@code true} if the input string is not null, and {@code false} otherwise.
 *
 * <p>Example usage:
 * <pre>{@code
 *     String carImageUrl = "https://www.example.com/images/cars/1.jpg";
 *     boolean isValidImageUrl = CheckCarImage.ToCheckCarImage(carImageUrl);
 * }</pre>
 *
 * @since 1.0
 */
public class CheckCarImage {

    /**
     * Checks if a given car image URL is valid or not.
     *
     * @param carimage the car image URL to check
     * @return {@code true} if the input string is not null, {@code false} otherwise.
     */
    public static boolean ToCheckCarImage(String carimage){
        boolean flag= false;
        if(carimage!=null  && !carimage.isEmpty()){
            flag=true;
        }
        return flag;
    }
}


