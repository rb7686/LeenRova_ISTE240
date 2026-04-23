// Leen Salaheddin Controller UID: 400003496
package org.example.assignment1.controllers;


import org.example.assignment1.model.Shipping;
import org.example.assignment1.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @GetMapping("/all")
    public List<Shipping> getAllShippings(){ return shippingService.getAllShippings(); }

    @GetMapping("/{id}")
    public Shipping getShippingById(@PathVariable Integer id){
        return shippingService.getShippingById(id);
    }

    @GetMapping("/search")
    public List<Shipping> getShipping(@RequestParam String city){
        return shippingService.getShippingByCity(city);
    }

    @PostMapping
    public void addShipping(@RequestBody Shipping shipping){
        this.shippingService.createShipping(shipping);
    }

    @PutMapping("/{id}")
    public Shipping updateShipping(@PathVariable Integer id, @RequestBody Shipping shipping){
        Shipping updatedShipping = shippingService.updateShipping(id, shipping);
        return updatedShipping;
    }

    @DeleteMapping("/{id}")
    public void deleteShipping(@PathVariable Integer id){
        shippingService.deleteShipping(id);
    }
}
