package com.mercedesbenz.carenquiry.util;



/**
 * The CheckCarPrice class contains a static method that checks the validity of a car price.
 * It checks if the car price is greater than 100 and not empty.
 *

 * @author SRIRAMH
 */
public class CheckCarPrice {

    /**
     * This static method checks if the given car price is valid or not.
     *
     * @param carprice The car price to be checked.
     * @return A boolean value indicating if the car price is valid or not.
     */
    public static boolean ToCheckCarPrice(int carprice){
        boolean flag= false;

        // Converting carprice to string
        String String_carprice = String.format(String.valueOf(carprice));

        // Checking if carprice is greater than 100 or not empty
        if(carprice>100 || String_carprice.isEmpty()){
            flag=true;
        }
        return flag;
    }
}
