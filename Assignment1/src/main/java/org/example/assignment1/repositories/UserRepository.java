// Leen Salaheddin Repository UID: 400003496


package org.example.assignment1.repositories;


import org.example.assignment1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Find methods
    List<User> findAll();
    Optional<User> findById(Integer id);

    @Query("SELECT u FROM User u WHERE u.firstName = :firstName")
    List<User> findByFirstName(@Param("firstName") String firstName);

    //Update method
    @Modifying
    @Query("UPDATE User u SET u.phoneNumber = :phoneNumber WHERE u.id = :id")
    int updatePhoneNumberById(@Param("id") Integer id, @Param("phoneNumber") int phoneNumber);

    // Delete method
    void deleteById(Integer id);
}