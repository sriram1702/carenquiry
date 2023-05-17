//package com.mercedesbenz.carenquiry.service;
//
//import com.mercedesbenz.carenquiry.exception.ProperCarDetails;
//import com.mercedesbenz.carenquiry.model.Cars;
//import com.mercedesbenz.carenquiry.repository.CarRepository;
//import com.mercedesbenz.carenquiry.util.CheckCarImage;
//import com.mercedesbenz.carenquiry.util.CheckCarName;
//import com.mercedesbenz.carenquiry.util.CheckCarPrice;
//import jakarta.validation.Valid;
//import org.apache.coyote.Response;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.http.HttpInputMessage;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.lang.NonNull;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Primary
//public class DBCarService {
//
//    @Autowired
//    CarRepository carRepository;
//
//    /**
//     *
//     * @param carRepository
//     * Creating a respository named carRepository
//
//     */
////    public  DBCarService(CarRepository carRepository){
////    this.carRepository=carRepository;
////}
//
//    /**
//     * @param cars
//     * @return cars created 201 code
//     * create car method is used to create car info in the db
//     *  this method is  used to create a car detail with carname,carimage and carprice
//     */
//
//
//    public ResponseEntity<Cars> Createcar(@RequestBody Cars cars) {
//        boolean carprice = CheckCarPrice.ToCheckCarPrice(cars.getCarprice());
//        boolean carimage = CheckCarImage.ToCheckCarImage(cars.getCarimage());
//        boolean carname = CheckCarName.ToCheckCarName(cars.getCarname());
//        ArrayList<String> errordetails = new ArrayList<>();
//        boolean errorflag = false;
//        StringBuilder errormessage = new StringBuilder("please enter the following details correctly\n");
//        if (!carprice) {
//            errorflag = true;
//            errormessage.append("car price\n");
////            errordetails.add("Car Price");
//        }
//        if (!carname) {
//            errorflag = true;
//            errormessage.append("car name\n");
////            errordetails.add("Car name");
//        }
//        if (!carimage) {
//            errorflag = true;
//            errormessage.append("car image\n");
////            errordetails.add("Car image");
//        }
//
//        if (errorflag == true) {
//
//            String message = String.valueOf(new ProperCarDetails(errormessage.toString()).getMessage());
//
//            return new ResponseEntity(message, HttpStatus.CONFLICT);
//        }
////        try {
//        Cars savecars = carRepository.save(cars);
//
//        return new ResponseEntity<Cars>(savecars, HttpStatus.CREATED);
////        } catch (Exception e) {
////            System.out.println(e);
////            return new ResponseEntity("Some error occurred", HttpStatus.NOT_FOUND);
////        }
//
//
//    }
//
//
//    /**
//     * @param id
//     * @return to find particular car info by giving id as param
//     */
//    public ResponseEntity<Cars> FindbyId(int id) {
//        Optional<Cars> car = carRepository.findById(id);
//        if (car.isPresent()) {
//            return new ResponseEntity<>(car.get(), HttpStatus.FOUND);
//        } else {
//            return new ResponseEntity ("Id not found in the database", HttpStatus.NOT_FOUND);
//
//        }
//    }
//
//
//
//
//
//
//
//    /**
//     * @return all  cars from the db
//     */
//    public ResponseEntity<List<Cars>> GetAllCars() {
//        List<Cars> getallcars = carRepository.findAll();
//        return new ResponseEntity<List<Cars>>(getallcars, HttpStatus.OK);
//    }
//
//
//    /**
//     * @param id
//     * @return the car details will get updated
//     */
//    public ResponseEntity<Cars> UpdateCar(@Valid @NonNull @RequestBody Cars cars, int id) {
//        boolean carprice = CheckCarPrice.ToCheckCarPrice(cars.getCarprice());
//        boolean carimage = CheckCarImage.ToCheckCarImage(cars.getCarimage());
//        boolean carname = CheckCarName.ToCheckCarName(cars.getCarname());
//        ArrayList<String> errordetails = new ArrayList<>();
//        boolean errorflag = false;
//        StringBuilder errormessage = new StringBuilder("please enter the following details correctly\n");
//        if (!carprice) {
//            errorflag = true;
//            errormessage.append("car price\n");
////            errordetails.add("Car Price");
//        }
//        if (!carname) {
//            errorflag = true;
//            errormessage.append("car name\n");
////            errordetails.add("Car name");
//        }
//        if (!carimage) {
//            errorflag = true;
//            errormessage.append("car image\n");
////            errordetails.add("Car image");
//        }
//
//        if (errorflag == true) {
//
//            String message = String.valueOf(new ProperCarDetails(errormessage.toString()).getMessage());
//
//            return new ResponseEntity(message, HttpStatus.CONFLICT);
//        }
//        try {
//            carRepository.existsById(id);
//
//            Cars updatecar = carRepository.findById(id).get();
//            updatecar.setCarname(cars.getCarname());
//            updatecar.setCarimage(cars.getCarimage());
//            updatecar.setCarprice(cars.getCarprice());
//            carRepository.save(updatecar);
//
//            return new ResponseEntity<Cars>(updatecar, HttpStatus.OK);
//        } catch (Exception e){
//            return new ResponseEntity("Some error occurred", HttpStatus.NOT_FOUND);
//        }
//
//    }
//
//    /**
//     * @param id this method used to delete the car info by taking id as param
//     */
//    public  ResponseEntity<String>  deleteCar(int id){
//
//        if(carRepository.existsById(id)){
//
//            carRepository.deleteById(id);
//            return new ResponseEntity("Deleted",HttpStatus.OK);
//        }
//        else {
//
//
//            return new ResponseEntity("Car Not found", HttpStatus.NOT_FOUND);
//        }
//    }
//}
//
//

package com.mercedesbenz.carenquiry.service;
/**
 *  This package contains all the classes and interfaces related to the Car Enquiry API.
 */
import com.mercedesbenz.carenquiry.exception.ProperCarDetails;
import com.mercedesbenz.carenquiry.model.Cars;
import com.mercedesbenz.carenquiry.repository.CarRepository;
import com.mercedesbenz.carenquiry.util.CheckCarImage;
import com.mercedesbenz.carenquiry.util.CheckCarName;
import com.mercedesbenz.carenquiry.util.CheckCarPrice;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *      This class provides a service layer for the CarRepository class to perform various operations related to the Cars entity.
 */
@Service
@Primary

public class DBCarService {
    /**

     This class provides a service layer for the CarRepository class to perform various operations related to the Cars entity.
     This includes adding a new car, getting details of a particular car by its id, updating details of a particular car by its id,
     deleting a particular car by its id, and getting the list of all cars available.
     */

    @Autowired
    CarRepository carRepository;


//    public  DBCarService(CarRepository carRepository){
//    this.carRepository=carRepository;
//}

    /**
     * Creates a new car in the database.
     *
     * @param cars The Cars object to be saved.
     * @return A ResponseEntity containing the saved Cars object and a status code of 201 if successful,
     *         or a message and a status code of 409 if there are validation errors.
     */

    public ResponseEntity<Cars> Createcar(@RequestBody Cars cars) {
        boolean carprice = CheckCarPrice.ToCheckCarPrice(cars.getCarprice());
        boolean carimage = CheckCarImage.ToCheckCarImage(cars.getCarimage());
        boolean carname = CheckCarName.ToCheckCarName(cars.getCarname());
        ArrayList<String> errordetails = new ArrayList<>();
        boolean errorflag = false;
        StringBuilder errormessage = new StringBuilder("please enter the following details correctly\n");
        if (!carprice) {
            errorflag = true;
            errormessage.append("car price\n");
//            errordetails.add("Car Price");
        }
        if (!carname) {
            errorflag = true;
            errormessage.append("car name\n");
//            errordetails.add("Car name");
        }
        if (!carimage) {
            errorflag = true;
            errormessage.append("car image\n");
//            errordetails.add("Car image");
        }

        if (errorflag == true) {

            String message = String.valueOf(new ProperCarDetails(errormessage.toString()).getMessage());

            return new ResponseEntity(message, HttpStatus.CONFLICT);
        }
//        try {
        Cars savecars = carRepository.save(cars);

        return new ResponseEntity<Cars>(savecars, HttpStatus.CREATED);
//        } catch (Exception e) {
//            System.out.println(e);
//            return new ResponseEntity("Some error occurred", HttpStatus.NOT_FOUND);
//        }


    }


    /**
     * Retrieves a car with the specified id from the database.
     *
     * @param id The id of the car to be retrieved.
     * @return A ResponseEntity containing the retrieved car and an HTTP status of 200 (OK) if the car is found,
     *         or a ResponseEntity with an error message and an HTTP status of 404 (Not Found) if the id is not found.
     */

    public ResponseEntity<Cars> FindbyId(int id) {
        if (carRepository.existsById(id)) {
            Cars car = carRepository.findById(id).get();

            return new ResponseEntity<Cars>(car, HttpStatus.FOUND);
        } else {
            return new ResponseEntity ("Id not found in the database", HttpStatus.NOT_FOUND);

        }

    }







    /**
     * Retrieves all the cars in the database and returns them in a response entity with status code 200 OK.
     *
     * @return A response entity containing a list of all the cars in the database with status code 200 OK.
     */






    public ResponseEntity<List<Cars>> GetAllCars() {
        List<Cars> getallcars = carRepository.findAll();
        return new ResponseEntity<List<Cars>>(getallcars, HttpStatus.OK);
    }


    /**
     * This method is used to update the details of a car in the database with the given ID.
     * It checks if the provided car name, car image, and car price are valid or not, and returns an error response if any of them are invalid.
     * If all the details are valid, it updates the car details and returns a response with the updated car object and HTTP status OK.
     * If the given ID does not exist in the database, it returns a response with an error message and HTTP status NOT_FOUND.
     *
     * @param cars      the car object containing the updated details
     * @param id        the ID of the car to be updated
     * @return          a response entity with the updated car object and HTTP status OK, or an error message and HTTP status NOT_FOUND or CONFLICT
     */
    public ResponseEntity<Cars> UpdateCar(@Valid @NonNull @RequestBody Cars cars, int id) {
        boolean carprice = CheckCarPrice.ToCheckCarPrice(cars.getCarprice());
        boolean carimage = CheckCarImage.ToCheckCarImage(cars.getCarimage());
        boolean carname = CheckCarName.ToCheckCarName(cars.getCarname());
        ArrayList<String> errordetails = new ArrayList<>();
        boolean errorflag = false;
        StringBuilder errormessage = new StringBuilder("please enter the following details correctly\n");
        if (!carprice) {
            errorflag = true;
            errormessage.append("car price\n");
// errordetails.add("Car Price");
        }
        if (!carname) {
            errorflag = true;
            errormessage.append("car name\n");
// errordetails.add("Car name");
        }
        if (!carimage) {
            errorflag = true;
            errormessage.append("car image\n");
// errordetails.add("Car image");
        }

        if (errorflag == true) {

            String message = String.valueOf(new ProperCarDetails(errormessage.toString()).getMessage());

            return new ResponseEntity(message, HttpStatus.CONFLICT);
        }
        try {
            carRepository.existsById(id);

            Cars updatecar = carRepository.findById(id).get();
            updatecar.setCarname(cars.getCarname());
            updatecar.setCarimage(cars.getCarimage());
            updatecar.setCarprice(cars.getCarprice());
            carRepository.save(updatecar);

            return new ResponseEntity<Cars>(updatecar, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity("Some error occurred", HttpStatus.NOT_FOUND);
        }

    }
    /**
     * Deletes a car with the given ID from the database.
     *
     * @param id the ID of the car to delete
     * @return a ResponseEntity with a success message and HTTP status code 200 if the car was deleted successfully,
     *         or a ResponseEntity with an error message and HTTP status code 404 if the car was not found in the database.
     */
    public  ResponseEntity<String>  deleteCar(int id){


        if( carRepository.existsById(id)){

            carRepository.deleteById(id);
            return new ResponseEntity("Deleted",HttpStatus.OK);
        }
        else {


            return new ResponseEntity("Car Not found", HttpStatus.NOT_FOUND);
        }
    }

}


