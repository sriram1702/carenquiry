package com.mercedesbenz.carenquiry.util;



/**
 * The CheckCarName class provides a utility method for checking if the car name is not null.
 *
 * @since 1.0
 */
public class CheckCarName {

    /**
     * Returns true if the car name is not null, false otherwise.
     *
     * @param carname the name of the car to be checked
     * @return true if the car name is not null, false otherwise
     */
    public static boolean ToCheckCarName(String carname){
        boolean flag= false;
        if(carname!=null && !carname.isEmpty()){
            flag=true;
        }
        return flag;
    }
}



