

        package com.mercedesbenz.carenquiry;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercedesbenz.carenquiry.controller.CarController;
import com.mercedesbenz.carenquiry.exception.ProperCarDetails;
import com.mercedesbenz.carenquiry.model.Cars;
import com.mercedesbenz.carenquiry.repository.CarRepository;
import com.mercedesbenz.carenquiry.service.DBCarService;
import com.mercedesbenz.carenquiry.swaggerconfig.SwaggerConfig;
import com.mercedesbenz.carenquiry.util.CheckCarImage;
import com.mercedesbenz.carenquiry.util.CheckCarName;
import com.mercedesbenz.carenquiry.util.CheckCarPrice;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ComponentScan(basePackages = "com.mercedesbenz.carenquiry")
@AutoConfigureMockMvc
@SpringBootTest
public class CarControllerTest{
// @Test
// void contextLoads() {
// }

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper= new ObjectMapper();

    @Mock
    private CarRepository carRepository;
    @InjectMocks
    private CheckCarPrice checkCarPrice;
    @InjectMocks
    private CheckCarImage checkCarImage;
    @InjectMocks
    private CheckCarName checkCarName;
    @Mock
    private DBCarService dbCarService;

    @InjectMocks
    private CarController carController;
     @InjectMocks
     private  SwaggerConfig swaggerConfig;

    private ObjectMapper mapper;


// List<Cars> cars = new ArrayList<>(Arrays.asList(cars1,cars2,cars3,cars4));


    @Mock
    private AutoCloseable closeable;

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

    }
    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(carController).build();

// this.mockMvc = MockMvcBuilders.standaloneSetup(checkCarPrice).build();
// this.mockMvc = MockMvcBuilders.standaloneSetup(checkCarImage).build();
// this.mockMvc = MockMvcBuilders.standaloneSetup(checkCarName).build();
    }


    public Cars cars1 = new Cars(1,"Mustang GT","https://image.com/Mustang%20GT",200000);
    public Cars cars2 = new Cars(2,"Ferrari","https://image.com/Ferrari",300000);
    public Cars cars3 = new Cars(3,"Thar","https://image.com/Thar",250000);
    public Cars cars4 = new Cars(4,"Mazda","https://image.com/Mazda",150000);
//    @Test
//    public void testMain() {
//        SpringApplication mockApplication = Mockito.mock(SpringApplication.class);
//        String[] args = {};
//        CarenquiryApplication.main(args);
//        Mockito.verify(mockApplication, Mockito.times(1)).run(CarenquiryApplication.class, args);
//    }

//    @Test
//    public void post_success() throws Exception {
//// Cars cars = Cars.builder().id(2).carimage("dsd").carname("ads").carprice(233223).build();
//
//        Mockito.when(carRepository.save(cars1)).thenReturn(cars1);
//        Mockito.when(dbCarService.Createcar(cars1)).thenReturn(new ResponseEntity(cars1,HttpStatus.CREATED));
//// assertEquals("Mustang GT",carController.Createcar(cars1).getBody().getCarname());
//
//
//        String jsonbody = objectMapper.writeValueAsString(cars1);
//
// this.mockMvc.perform(post("/api/v1/cars/createcar")
// .content(jsonbody)
// .contentType(MediaType.APPLICATION_JSON)
//         )
// .andExpect(status().isCreated())
//// .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Superman"))
// .andDo(print());
//    }


    @Test
    public void post_fail_exception_CARPRICE() throws Exception {
// Cars cars = Cars.builder().id(2).carimage("dsd").carname("ads").carprice(233223).build();
        Cars cars5=new Cars("duster","random.jpg",90);
// when(carRepository.save(cars1)).thenThrow(new RuntimeException());
        Mockito.when(dbCarService.Createcar(cars5)).thenReturn(new ResponseEntity("please enter the following details correctly\ncar price\n",HttpStatus.CONFLICT));
//        assertEquals(null,carController.Createcar(cars5).);

        String jsonbody = objectMapper.writeValueAsString(cars5);

        this.mockMvc.perform(post("/api/v1/cars/createcar")
                        .content(jsonbody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
// .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Superman"))
                .andDo(print());
    }

    @Test
    public void post_fail_exception_CARNAME() throws Exception {
// Cars cars = Cars.builder().id(2).carimage("dsd").carname("ads").carprice(233223).build();
        Cars cars5=new Cars(null,"random.jpg",10000);
// when(carRepository.save(cars1)).thenThrow(new RuntimeException());
        Mockito.when(dbCarService.Createcar(cars5)).thenReturn(new ResponseEntity("please enter the following details correctly\ncar name\n",HttpStatus.CONFLICT));
//        assertEquals(null,carController.Createcar(cars5).);

        String jsonbody = objectMapper.writeValueAsString(cars5);

        this.mockMvc.perform(post("/api/v1/cars/createcar")
                        .content(jsonbody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
// .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Superman"))
                .andDo(print());
    }

    @Test
    public void post_fail_exception_CARIMAGE() throws Exception {
// Cars cars = Cars.builder().id(2).carimage("dsd").carname("ads").carprice(233223).build();
        Cars cars5=new Cars("duster",null,10000);
// when(carRepository.save(cars1)).thenThrow(new RuntimeException());
        Mockito.when(dbCarService.Createcar(cars5)).thenReturn(new ResponseEntity("please enter the following details correctly\ncar image\n",HttpStatus.CONFLICT));
//        assertEquals(null,carController.Createcar(cars5).);

        String jsonbody = objectMapper.writeValueAsString(cars5);

        this.mockMvc.perform(post("/api/v1/cars/createcar")
                        .content(jsonbody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
// .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Superman"))
                .andDo(print());
    }


// @Test
// public void post_success_fail() throws Exception {
// Cars car = new Cars();
// car.setCarname("");
// car.setCarprice(1);
// car.setCarimage("");
//// Cars cars = Cars.builder().id(2).carimage("dsd").carname("ads").carprice(233223).build();
//// Mockito.when(carRepository.save(car)).thenThrow();
//// Mockito.when(dbCarService.Createcar(car)).thenReturn("please enter the following details correctly\ncar price\ncar name\ncar image\n");
//
// when(dbCarService.Createcar(car)).thenThrow(new ProperCarDetails("please enter the following details correctly\ncar price\n"));
// Assertions.assertEquals("please enter the following details correctly\ncar price\n", dbCarService.Createcar(car));
//
// String jsonbody = objectMapper.writeValueAsString(car);
//
// this.mockMvc.perform(post("/api/v1/cars/createcar")
// .content(jsonbody)
// .contentType(MediaType.APPLICATION_JSON))
// .andExpect(status().isNotFound())
//// .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Superman"))
// .andDo(print());
// }





    @Test
    public void findbyId_success() throws Exception {
        int id = 2;
        Cars c = new Cars(2, "Thar", "http://google", 21313);
        Mockito.when(carRepository.existsById(id)).thenReturn(true);
        Mockito.when(carRepository.findById(id)).thenReturn(Optional.of(c));
        Mockito.when(carController.findbyId(id)).thenReturn(new ResponseEntity(c,HttpStatus.FOUND));

// explicitly return a non-null ResponseEntity object
        Mockito.when(dbCarService.FindbyId(id)).thenReturn(new ResponseEntity(c,HttpStatus.FOUND));

//        ResponseEntity<Cars> responseEntity = dbCarService.FindbyId(id);
//
//        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());
//        assertEquals(c, responseEntity.getBody());
//        this.mockMvc.perform(
//                        get("/api/v1/cars/{id}",id))
//                .andExpect(status().isFound())
//                .andDo(print());
    }

    @Test
    public void findbyId_fail() throws Exception {
        int id = 2;
        Cars c = new Cars(2, "Thar", "http://google", 21313);
        Mockito.when(carRepository.findById(id)).thenReturn(Optional.of(c));
        Mockito.when(carController.findbyId(id)).thenReturn(new ResponseEntity("Id not found in the database",HttpStatus.NOT_FOUND));

// explicitly return a non-null ResponseEntity object
        Mockito.when(dbCarService.FindbyId(id)).thenReturn(new ResponseEntity(c,HttpStatus.NOT_FOUND));

        ResponseEntity<Cars> responseEntity = dbCarService.FindbyId(id);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(c, responseEntity.getBody());
        this.mockMvc.perform(
                        get("/api/v1/cars/{id}",id))
                .andExpect(status().isNotFound())
                .andDo(print());
    }


    @Test
    public void findAllCars() throws Exception {

        List cars = new ArrayList(List.of(cars1,cars2,cars3,cars4));
        Mockito.when(carRepository.findAll()).thenReturn(cars);
        Mockito.when(dbCarService.GetAllCars()).thenReturn(new ResponseEntity(cars,HttpStatus.OK));
        Mockito.when(carController.findAllCars()).thenReturn(new ResponseEntity(cars,HttpStatus.OK));
        assertEquals(4,carController.findAllCars().getBody().size());

        this.mockMvc.perform(get("/api/v1/cars"))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void updateCarById_success() throws Exception{
        int id = 3;

        Cars originalCar = new Cars("Mazda","https://image.com/Mazda",150000);
        Cars updatedCar = new Cars("Mazdaa","https://image.com/Mazda",150000);

        Mockito.when(carRepository.existsById(id)).thenReturn(true);
        Mockito.when(carRepository.save(updatedCar)).thenReturn(updatedCar);
        Mockito.when(carRepository.findById(id)).thenReturn(Optional.of(originalCar));
        Mockito.when(dbCarService.UpdateCar(updatedCar,id)).thenReturn(new ResponseEntity<>(updatedCar,HttpStatus.OK));
        Mockito.when(carController.updateCarById(id,updatedCar)).thenReturn(new ResponseEntity<>(updatedCar,HttpStatus.OK));
        assertEquals(new ResponseEntity<>(updatedCar,HttpStatus.OK),dbCarService.UpdateCar(updatedCar,id));
        String jsonbody = objectMapper.writeValueAsString(updatedCar);

//        this.mockMvc.perform(
//                        put("/api/v1/cars/{id}",id,updatedCar).content(jsonbody).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(print());
    }

    @Test
    public void updateCarById_failure() throws Exception{
        int id = 22;
        Cars originalCar = new Cars("Mazda","https://image.com/Mazda",150000);

         Mockito.when(carRepository.existsById(id)).thenReturn(false);
         Mockito.when(carController.updateCarById(id,originalCar)).thenReturn(new ResponseEntity("Some error occurred", HttpStatus.NOT_FOUND));
         Mockito.when(dbCarService.UpdateCar(originalCar,id)).thenReturn(new ResponseEntity("Some error occurred", HttpStatus.NOT_FOUND));

        this.mockMvc.perform(
                        put("/api/v1/cars/{id}",id,originalCar))
//                .andExpect(status().isNotFound())
                .andDo(print());
    }


    @Test
    public void updateCarById_failure_CARPRICE() throws Exception{
        int id = 30;

        Cars updatedCar = new Cars("Mazdaa","https://image.com/Mazda",10);
        Mockito.when(carRepository.existsById(id)).thenReturn(false);
        Mockito.when(dbCarService.UpdateCar(updatedCar,id)).thenReturn(new ResponseEntity("please enter the following details correctly\n" +
                "car price",HttpStatus.CONFLICT));
        Mockito.when(carController.updateCarById(id,updatedCar)).thenReturn(new ResponseEntity("please enter the following details correctly\n" +
                "car price",HttpStatus.CONFLICT));

        String jsonbody = objectMapper.writeValueAsString(updatedCar);

        this.mockMvc.perform(
                        put("/api/v1/cars/{id}",id).content(jsonbody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
                .andDo(print());
    }

    @Test
    public void updateCarById_failure_CARIMAGE() throws Exception{
        int id = 30;

        Cars originalCar = new Cars("Mazda",null,15000);
        Cars updatedCar = new Cars("Mazdaa",null,10000);
//        Mockito.when(carRepository.save(updatedCar)).thenReturn(updatedCar);
        Mockito.when(carRepository.existsById(id)).thenReturn(false);
//        Mockito.when(carRepository.findById(id)).thenReturn(Optional.of(originalCar));
        Mockito.when(dbCarService.UpdateCar(updatedCar,id)).thenReturn(new ResponseEntity("please enter the following details correctly\n" +
                "car image",HttpStatus.CONFLICT));
        Mockito.when(carController.updateCarById(id,updatedCar)).thenReturn(new ResponseEntity("please enter the following details correctly\n" +
                "car image",HttpStatus.CONFLICT));

        String jsonbody = objectMapper.writeValueAsString(updatedCar);

        this.mockMvc.perform(
                        put("/api/v1/cars/{id}",id).content(jsonbody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
                .andDo(print());
    }

    @Test
    public void updateCarById_failure_CARNAME() throws Exception{
        int id = 30;

        Cars originalCar = new Cars(null,"https://image.com/Mazda",15000);
        Cars updatedCar = new Cars(null,"https://image.com/Mazda",10000);
//        Mockito.when(carRepository.save(updatedCar)).thenReturn(updatedCar);
        Mockito.when(carRepository.existsById(id)).thenReturn(false);
//        Mockito.when(carRepository.findById(id)).thenReturn(Optional.of(originalCar));
        Mockito.when(dbCarService.UpdateCar(updatedCar,id)).thenReturn(new ResponseEntity("please enter the following details correctly\n" +
                "car name",HttpStatus.CONFLICT));
        Mockito.when(carController.updateCarById(id,updatedCar)).thenReturn(new ResponseEntity("please enter the following details correctly\n" +
                "car name",HttpStatus.CONFLICT));

        String jsonbody = objectMapper.writeValueAsString(updatedCar);

        this.mockMvc.perform(
                        put("/api/v1/cars/{id}",id).content(jsonbody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
                .andDo(print());
    }


// @Test
// public void updateCarById_fail() throws Exception{
// int id = 3;
// Cars updatedCar = new Cars();
// updatedCar.setCarname("");
// updatedCar.setCarprice(1000);
// updatedCar.setCarimage("");
//// Cars cars = Cars.builder().id(2).carimage("dsd").carname("ads").carprice(233223).build();
//// Mockito.when(carRepository.save(car)).thenThrow();
//// Mockito.when(dbCarService.Createcar(car)).thenReturn("please enter the following details correctly\ncar price\ncar name\ncar image\n");
//
// when(CheckCarPrice.ToCheckCarPrice(1)).thenReturn(false);
// when(CheckCarImage.ToCheckCarImage("")).thenReturn(false);
// when(CheckCarName.ToCheckCarName("")).thenReturn(false);
// doThrow(new ProperCarDetails("please enter the following details correctly\ncar price\n")).when(dbCarService.Createcar(updatedCar));
// Assertions.assertEquals("please enter the following details correctly\ncar price\n", dbCarService.Createcar(updatedCar));
//
//// Mockito.when(carRepository.save(updatedCar)).thenReturn(updatedCar);
//// Mockito.when(dbCarService.UpdateCar(cars3,id)).thenReturn(new ResponseEntity<>(updatedCar,HttpStatus.OK));
//
// String jsonbody = objectMapper.writeValueAsString(updatedCar);
//
// this.mockMvc.perform(
// put("/api/v1/cars/{id}",id).content(jsonbody).contentType(MediaType.APPLICATION_JSON))
// .andExpect(status().isOk())
// .andDo(print());
// }




//    @Test
//    public void delete_success() throws Exception {
//        int id = 2;
//
//        doNothing().when(carRepository).deleteById(id);
//        when(carRepository.existsById(id)).thenReturn(true);
//        when(dbCarService.deleteCar(id)).thenReturn(new ResponseEntity<>("Deleted", HttpStatus.OK));
//
//        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/cars/{id}", id))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }


    @Test
    public void delete_fail() throws Exception {
        int id = 90;
        doNothing().when(carRepository).deleteById(id);
        when(carRepository.existsById(id)).thenReturn(false);
        when(dbCarService.deleteCar(id)).thenReturn(new ResponseEntity("Car Not found",HttpStatus.NOT_FOUND));

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/cars/{id}",id))
                .andExpect(status().isNotFound()).andDo(print());
    }
//    @Test
//    public void testDeleteCarNotFound() {
//        int id = 1;
//        when(carRepository.findById(id)).thenReturn(Optional.empty());
//
//        ResponseEntity<String> response = carController.deleteCar(id);
//
//        verify(carRepository, times(1)).findById(id);
//        verify(carRepository, never()).deleteById(id);
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertEquals("Car Not found", response.getBody());
//    }

}


