package org.example.assignment1.repositories;
// Leen Salaheddin Repository UID: 400003496


import org.example.assignment1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    // Find methods
    List<Order> findAll();
    Optional<Order> findById(Integer orderID);

    @Query("SELECT o FROM Order o WHERE o.status = :status")
    List<Order> findByOrderMethod(@Param("status") String status);

    //Update method
    @Modifying
    @Query("UPDATE Order o SET o.numberOfItems = :numberOfItems WHERE o.numberOfItems = :numberOfItems")
    int updatenumberOfItemsById(@Param("ID") Integer OrderID, @Param("Number of Items") int numberOfItems);

    // Delete method
    void deleteByid(Integer OrderID);
}