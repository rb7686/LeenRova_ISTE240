// Leen Salaheddin Service UID: 400003496

package org.example.assignment1.services;

import jakarta.transaction.Transactional;
import org.example.assignment1.model.Shipping;
import org.example.assignment1.repositories.ProductRepository;
import org.example.assignment1.repositories.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;
    @Autowired
    private ProductRepository productRepository;

    public Shipping getShippingById(Integer id) {
        Optional<Shipping> shipping = shippingRepository.findById(id);
        return shipping.orElse(null);
    }

    public List<Shipping> getShippingByCity(String city){
        return shippingRepository.findByCity(city);
    }

    public List<Shipping> getAllShippings(){
        return shippingRepository.findAll();
    }

    @Transactional
    public Shipping createShipping(Shipping shipping){
        return shippingRepository.save(shipping);
    }

    @Transactional
    public Shipping updateShipping(Integer id, Shipping updatedShipping) {
        Optional<Shipping> existingShippingOptional = shippingRepository.findById(id);
        if (existingShippingOptional.isPresent()) {
            Shipping existingShipping = existingShippingOptional.get();

            existingShipping.setCity(updatedShipping.getCity());
            existingShipping.setHomeNumber(updatedShipping.getHomeNumber());
            existingShipping.setStreetName(updatedShipping.getStreetName());

            return shippingRepository.save(existingShipping);
            return null;
        }
    }

    @Transactional
    public void deleteShipping(Integer id){
        shippingRepository.deleteById(id);
    }


}
