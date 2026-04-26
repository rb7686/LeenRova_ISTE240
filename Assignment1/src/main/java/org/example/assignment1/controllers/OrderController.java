// Leen Salaheddin Controller UID: 400003496

package org.example.assignment1.controllers;

import org.example.assignment1.model.Order;
import org.example.assignment1.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAllOrders(){ return orderService.getAllOrders(); }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Integer id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/search")
    public List<Order> getOrder(@RequestParam String status){
        return orderService.getOrderByStatus(status);
    }

    @PostMapping
    public void addOrder(@RequestBody Order order){
        this.orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Integer id, @RequestBody Order order){
        Order updatedOrder = orderService.updateOrder(id, order);
        return updatedOrder;
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
    }
}