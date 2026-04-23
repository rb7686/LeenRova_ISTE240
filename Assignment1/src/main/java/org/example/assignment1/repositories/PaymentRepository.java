// ROVA BADAVI UID: 761002045
package org.example.assignment1.repositories;

import org.example.assignment1.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // Find methods
    List<Payment> findAll();
    Optional<Payment> findById(Integer id);

    // Find method with JPQL
    @Query("SELECT pay FROM Payment pay WHERE pay.paymentMethod = :paymentMethod")
    List<Payment> findByPaymentMethod(@Param("paymentMethod") String paymentMethod);

    //Update method
    @Modifying
    @Query("UPDATE Payment pay SET pay.paymentAmount = :paymentAmount WHERE pay.paymentID = :id")
    int updatePaymentAmountById(@Param("id") Integer id, @Param("paymentAmount") double paymentAmount);

    // Delete method
    void deleteById(Integer id);
}
