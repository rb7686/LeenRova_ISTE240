// ROVA BADAVI UID:761002045
package org.example.assignment1.repositories;

import org.example.assignment1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Find methods
    List<Product> findAll();
    Optional<Product> findById(Integer id);

    // Find method with JPQL query
    @Query("SELECT p FROM Product p WHERE p.productName = :productName")
    List<Product> findByProductName(@Param("productName") String productName);

    //Update method
    @Modifying
    @Query("UPDATE Product p SET p.price = :price WHERE p.id = :id")
    int updatePriceById(@Param("id") Integer id, @Param("price") int price);

    // Delete method
    void deleteById(Integer id);
}
