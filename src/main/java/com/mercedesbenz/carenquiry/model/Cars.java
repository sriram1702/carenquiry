package com.mercedesbenz.carenquiry.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.annotation.processing.Generated;

/**
 * Represents a car with a name, image, and price.
 *
 * <p>
 * This class represents a car with a name, image, and price. It is used to store and retrieve car information from a database.
 * </p>
 *
 * <p>
 * Example usage:
 * </p>
 *
 * <pre>{@code
 * Cars car = new Cars("Mercedes-Benz C-Class", "https://example.com/images/mercedes_c_class.jpg", 50000);
 * car.setId(1);
 * carRepository.save(car);
 * }</pre>
 */
@Entity
@Table(name = "car")
public class Cars {


    @Id
//    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id ;
    @Column   @Value("string value")
    private  String carname;
    @Column  @Value("string value")
    private  String carimage;
    @Column
    private  int carprice;
    /**
     * Constructs a new Cars instance with the specified name, image, and price.
     *
     * @param carname the name of the car
     * @param carimage the URL of the car's image
     * @param carprice the price of the car
     */
    public Cars(String carname, String carimage, int carprice) {
        this.carname = carname;
        this.carimage = carimage;
        this.carprice = carprice;
    }

    /**
     * Constructs a new Cars instance with the specified ID, name, image, and price.
     * Note this constructor only for testing purposes
     * @param id the ID of the car
     * @param carname the name of the car
     * @param carimage the URL of the car's image
     * @param carprice the price of the car
     */
    public Cars(int id,String carname, String carimage, int carprice) {
        this.id = id;
        this.carname = carname;
        this.carimage = carimage;
        this.carprice = carprice;
    }

    /**
     * This is a constructor
     */
    public  Cars(){

    }
    /**
     * Returns the ID of the car.
     *
     * @return the ID of the car
     */
    public Integer getId() {
        return id;
    }
    /**
     * Sets the ID of the car.
     *
     * @param id the ID of the car
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Returns the URL of the car's image.
     *
     * @return the URL of the car's image
     */
    public String getCarimage() {
        return carimage;
    }
    /**
     * Sets the URL of the car's image.
     *
     * @param carimage the URL of the car's image
     */
    public void setCarimage(String carimage) {
        this.carimage = carimage;
    }
    /**
     * Returns the price of the car.
     *
     * @return the price of the car
     */
    public int getCarprice() {
        return carprice;
    }
    /**
     * Sets the price of the car.
     *
     * @param carprice the price of the car
     */
    public void setCarprice(int carprice) {
        this.carprice = carprice;
    }
    /**
     * Returns the name of the car.
     *
     * @return the name of the car
     */
    public String getCarname() {
        return carname;
    }
    /**
     * Sets the name of the car.
     *
     * @param carname the name of the car
     */
    public void setCarname(String carname) {
        this.carname = carname;
    }

}



