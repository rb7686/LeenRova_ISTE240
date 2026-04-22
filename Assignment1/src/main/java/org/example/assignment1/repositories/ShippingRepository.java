// Leen Salaheddin Repository UID: 400003496
package org.example.assignment1.repositories;


import org.example.assignment1.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ShippingRepository extends JpaRepository<Shipping, Integer> {

    // Find methods
    List<Shipping> findAll();
    Optional<Shipping> findById(Integer shippingID);

    @Query("SELECT s FROM Shipping s WHERE s.city = :city")
    List<Shipping> findByShippingMethod(@Param("city") String city);

    //Update method
    @Modifying
    @Query("UPDATE Shipping s SET s.streetName = :streetName WHERE s.streetName = :streetName")
    int updatestreetNameById(@Param("Shipping ID") Integer ShippingID, @Param("streetName") String streetName);

    // Delete method
    void deleteByid(Integer shippingID);
}