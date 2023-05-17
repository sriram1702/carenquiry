//package com.mercedesbenz.carenquiry.controller;
//
//import com.mercedesbenz.carenquiry.service.DBCarService;
//import com.mercedesbenz.carenquiry.model.Cars;
//import com.mercedesbenz.carenquiry.repository.CarRepository;
////import io.swagger.annotations.Api;
//
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.validation.Valid;
//import io.swagger.v3.oas.annotations.info.Contact;
//
//import  io.swagger.v3.oas.annotations.OpenAPIDefinition;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.lang.NonNull;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
///**
// * so our endpoint here is "http://localhost:8085/api/v1/cars"
// */
//@RequestMapping("/api/v1/cars")
//@Tag(name = "Car Enquiry")
//@CrossOrigin("http://localhost:3000")
//
//public class CarController {
//    /**
//     * This CarController has every REST API mappings
//     */
//    private  final DBCarService DBCarService;
//
//    @Autowired
//    private CarRepository carRepository;
//
//
//    public CarController(DBCarService DBCarService) {
//        this.DBCarService = DBCarService;
//    }
//
//    /**
//     *
//     * @param cars
//     * @return to create a post method we are using a endpoint known as "createcar"
//     */
//    @Operation(
//            description ="To create a car information please give carname ,carimage and carprice",
//            summary = "This is a endpoint to create a car info",
//            responses = {
//                    @ApiResponse(
//                            description = "Car Details Added Successfully",
//                            responseCode = "201"
//
//                    )
//            }
//
//    )
//    @PostMapping("/createcar")
//    public  ResponseEntity<Cars>Createcar( @Valid @NonNull @RequestBody Cars cars) {
//
//        ResponseEntity<Cars> response = DBCarService.Createcar(cars);
//        return response;
//    }
//
//    /**
//     *
//     * @param id
//     * @return to get the unique car detail by id
//     */
//    @Operation(
//            description ="To get a particular car information by id",
//            summary = "This is a endpoint to get a particular car info by id",
//            responses = {
//                    @ApiResponse(
//                            description = "Car Detail of a particular id is fetched successfully",
//                            responseCode = "200"
//
//                    )
//            }
//
//    )
//    @GetMapping("/{id}")
//    public ResponseEntity<Cars> findbyId(
//            @PathVariable("id") int id) {
//        return DBCarService.FindbyId(id);
//    }
//
//    /**
//     *
//     * @param id
//     * @return to update the car details using the id as a param
//     */
//    @Operation(
//            description ="To Update a car info like carname ,carimage and carprice",
//            summary = "This is a endpoint to update a  car info by id",
//            responses = {
//                    @ApiResponse(
//                            description = "Car Detail of a particular id is updated successfully",
//                            responseCode = "200"
//
//                    )
//            }
//
//    )
//    @PutMapping("/{id}")
//    public ResponseEntity<Cars> updateCarById(
//            @PathVariable("id") int id, @RequestBody Cars cars) {
//        return DBCarService.UpdateCar(cars,id);
//    }
//
//    /**
//     *
//     *  to get the details of the all cars
//     */
//    @Operation(
//            description ="To get all cars information",
//            summary = "This is a endpoint to get all cars info",
//            responses = {
//                    @ApiResponse(
//                            description = "Car Detail of all id is fetched successfully",
//                            responseCode = "200"
//
//                    )
//            }
//
//    )
//    @GetMapping
//    public ResponseEntity<List<Cars>> findAllCars() {
//        return DBCarService.GetAllCars();
//    }
//
//    /**
//     *
//     * @param id
//     * @return to delete a particular car by its id as param
//     */
//
//    @Operation(
//            description ="To delete  a particular car information by id",
//            summary = "This is a endpoint to delete a particular car info by id",
//            responses = {
//                    @ApiResponse(
//                            description = "Car Detail of a particular id is deleted successfully",
//                            responseCode = "200"
//
//                    )
//            }
//
//    )
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String>  deleteCar( @PathVariable ("id") int id){
//        ResponseEntity<String> response = DBCarService.deleteCar(id);
//        return response;
//    }}
//
//
//


package com.mercedesbenz.carenquiry.controller;
/**
 *  This package contains all the classes and interfaces related to the Car Enquiry API.
 */

import com.mercedesbenz.carenquiry.service.DBCarService;
import com.mercedesbenz.carenquiry.model.Cars;
import com.mercedesbenz.carenquiry.repository.CarRepository;
//import io.swagger.annotations.Api;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.info.Contact;

import  io.swagger.v3.oas.annotations.OpenAPIDefinition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * This CarController has every REST API mappings
 */
@RestController
///**
// * so our endpoint here is "http://localhost:8085/api/v1/cars"
// */
/**
 * This class defines the REST API endpoints for the Spring Boot application.
 */
@RequestMapping("/api/v1/cars")
@Tag(name = "Car Enquiry")
@CrossOrigin("http://localhost:3000")
/**
 * This CarController has every REST API mappings
 */
public class CarController {
    /**
     * This CarController has every REST API mappings
     */
    private  final DBCarService DBCarService;
    /**
     * This CarController has every REST API mappings
     */
    @Autowired
    private CarRepository carRepository;
    /**
     * This CarController has every REST API mappings
     * @param DBCarService this is used to use the services provided by dbcarservice in carcontroller
     */

    public CarController(DBCarService DBCarService) {
        this.DBCarService = DBCarService;
    }

//    /**
//     * Returns The car information with carname,carimage and carprice
//     * @param "carname" The carname must be string
//     * @param  "carimage"The carimage must be string
//     * @param  "carprice" The carprice must be integer
//     * @return to create a post method we are using a endpoint known as "/createcar"
//     */
    /**
     * Creates a new car in the database.
     *
     * @param cars the car object to create

     * @return a ResponseEntity containing the created car and a status code indicating success or failure
     *
     * <p>
     * This endpoint creates a new car in the database. The car object is passed as a JSON payload in the request body.
     * The car object must contain all required fields and must be valid according to the validation rules specified in
     * the Car class. If the car is successfully created, a ResponseEntity with the created car and an HTTP status code
     * of 201 (Created) is returned. If the car is not created for any reason, a ResponseEntity with an HTTP status code
     * of 400 (Bad Request) is returned.
     * </p>
     *
     * <p>
     * Note that the car object is validated using the @Valid annotation, which triggers validation of the car object
     * based on the validation rules defined in the Car class. The @NonNull annotation ensures that the car object is not null.
     * The car object is wrapped in a ResponseEntity to allow for more control over the HTTP response. This enables us to
     * set the response status code, headers, and other attributes.
     * </p>
     *
     * @throws RuntimeException if an error occurs while creating the car in the database
     */
    @Operation(
            description ="To create a car information please give carname ,carimage and carprice",
            summary = "This is a endpoint to create a car info",
            responses = {
                    @ApiResponse(
                            description = "Car Details Added Successfully",
                            responseCode = "201"

                    )
            }

    )
    @PostMapping("/createcar")
    public  ResponseEntity<Cars>Createcar( @Valid @NonNull @RequestBody Cars cars) {

        ResponseEntity<Cars> response = DBCarService.Createcar(cars);
        return response;
    }

    /**
     * Retrieves a car by its ID.
     *
     * @param id the ID of the car to retrieve
     * @return a ResponseEntity containing the car and a status code indicating success or failure
     *
     * <p>
     * This endpoint retrieves a car with the given ID from the database. If a car with the specified ID is found,
     * it is returned along with an HTTP status code of 200 (OK). If a car with the specified ID is not found, a
     * ResponseEntity with an HTTP status code of 404 (Not Found) is returned.
     * </p>
     *
     * <p>
     * Note that the car object is wrapped in a ResponseEntity to allow for more control over the HTTP response. This
     * enables us to set the response status code, headers, and other attributes.
     * </p>
     *
     * @throws RuntimeException if an error occurs while retrieving the car from the database
     */
    @Operation(
            description ="To get a particular car information by id",
            summary = "This is a endpoint to get a particular car info by id",
            responses = {
                    @ApiResponse(
                            description = "Car Detail of a particular id is fetched successfully",
                            responseCode = "200"

                    ),
                    @ApiResponse(
                            description = "Car Detail of a particular id is fetched successfully",
                            responseCode = "302"

                    )
            }

    )
    @GetMapping("/{id}")
    public ResponseEntity<Cars> findbyId(
            @PathVariable("id") int id) {

        return DBCarService.FindbyId(id);
    }

    /**
     * Updates an existing car in the database.
     *
     * @param id the ID of the car to update
     * @param cars the updated car object
     * @return a ResponseEntity containing the updated car and a status code indicating success or failure
     *
     * <p>
     * This endpoint updates an existing car in the database. The car object is passed as a JSON payload in the request body,
     * and the ID of the car to update is passed as a path variable. The car object must contain all required fields and must
     * be valid according to the validation rules specified in the Car class. If the car is successfully updated, a ResponseEntity
     * with the updated car and an HTTP status code of 200 (OK) is returned. If the car is not updated for any reason, a
     * ResponseEntity with an HTTP status code of 404 (Not Found) is returned.
     * </p>
     *
     * <p>
     * Note that the car object is validated using the @Valid annotation, which triggers validation of the car object based on
     * the validation rules defined in the Car class. The car object is wrapped in a ResponseEntity to allow for more control
     * over the HTTP response. This enables us to set the response status code, headers, and other attributes.
     * </p>
     *
     * @throws RuntimeException if an error occurs while updating the car in the database
     */
    @Operation(
            description ="To Update a car info like carname ,carimage and carprice",
            summary = "This is a endpoint to update a  car info by id",
            responses = {
                    @ApiResponse(
                            description = "Car Detail of a particular id is updated successfully",
                            responseCode = "200"

                    )
            }

    )
    @PutMapping("/{id}")
    public ResponseEntity<Cars> updateCarById(
            @PathVariable("id") int id, @RequestBody Cars cars) {
        return DBCarService.UpdateCar(cars,id);
    }
    /**
     * Retrieves a list of all cars from the database.
     *
     * @return a ResponseEntity containing a list of cars and a status code indicating success or failure
     *
     * <p>
     * This endpoint retrieves a list of all cars from the database. The list of cars is wrapped in a ResponseEntity to allow
     * for more control over the HTTP response. This enables us to set the response status code, headers, and other attributes.
     * If the list of cars is successfully retrieved, a ResponseEntity with the list of cars and an HTTP status code of 200 (OK)
     * is returned. If the list of cars cannot be retrieved for any reason, a ResponseEntity with an HTTP status code of 404 (Not Found)
     * is returned.
     * </p>
     *
     * <p>
     * Note that this method uses the @GetMapping annotation, which maps the endpoint to an HTTP GET request. The method simply
     * delegates the retrieval of the list of cars to the DBCarService.GetAllCars() method, which interacts with the database
     * to retrieve the list of cars.
     * </p>
     *
     * @throws RuntimeException if an error occurs while retrieving the list of cars from the database
     */
    @Operation(
            description ="To get all cars information",
            summary = "This is a endpoint to get all cars info",
            responses = {
                    @ApiResponse(
                            description = "Car Detail of all id is fetched successfully",
                            responseCode = "200"

                    )
            }

    )
    @GetMapping
    public ResponseEntity<List<Cars>> findAllCars() {
        return DBCarService.GetAllCars();
    }

    /**
     * Deletes a car from the database by its ID.
     *
     * @param id the ID of the car to delete
     * @return a ResponseEntity containing a message indicating whether the deletion was successful and a status code indicating success or failure
     *
     * <p>
     * This endpoint deletes a car from the database by its ID. The ID of the car is passed as a path variable. The method delegates
     * the deletion to the DBCarService.deleteCar() method, which interacts with the database to delete the car. If the deletion is successful,
     * a ResponseEntity with a message indicating success and an HTTP status code of 204 (No Content) is returned. If the deletion fails because
     * the car with the specified ID does not exist, a ResponseEntity with a message indicating failure and an HTTP status code of 404 (Not Found)
     * is returned.
     * </p>
     *
     * <p>
     * Note that this method uses the @DeleteMapping annotation, which maps the endpoint to an HTTP DELETE request. The method simply
     * delegates the deletion of the car to the DBCarService.deleteCar() method, which interacts with the database to delete the car.
     * </p>
     *
     * @throws RuntimeException if an error occurs while deleting the car from the database
     */

    @Operation(
            description ="To delete  a particular car information by id",
            summary = "This is a endpoint to delete a particular car info by id",
            responses = {
                    @ApiResponse(
                            description = "Car Detail of a particular id is deleted successfully",
                            responseCode = "200"

                    )
            }

    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteCar( @PathVariable ("id") int id){
        ResponseEntity<String> response = DBCarService.deleteCar(id);
        return response;
    }
}



