/**

 The CarRepository interface extends the JpaRepository interface to provide
 database access methods for the Cars entity. It inherits all the CRUD methods
 from JpaRepository and adds additional custom methods for querying the Cars
 entity.
 This interface includes a method for finding a car by name and a method for
 deleting a car by name. These methods are commented out but can be uncommented
 if needed.
 Additionally, this interface includes a custom query method using the @Query
 annotation to find a car by ID. The query uses the @Param annotation to specify
 the method parameter for the ID value.
 */
package com.mercedesbenz.carenquiry.repository;
/**
 *  This package contains all the classes and interfaces related to the Car Enquiry API.
 */
import com.mercedesbenz.carenquiry.model.Cars;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * This carRepository extends a jpaRepository where jpa will give many methods like findall,save etc..
 */
public interface CarRepository extends JpaRepository<Cars,Integer> {
//Cars findByCarname(String carname);
//@Transactional
// void deleteByCarname(String carname);


//    @Query("from Cars where id= :id")
//    Cars findById(@Param("id") int id);


}