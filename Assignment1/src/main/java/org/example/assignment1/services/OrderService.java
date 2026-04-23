package org.example.assignment1.services;


import jakarta.transaction.Transactional;
import org.example.assignment1.model.Order;
import org.example.assignment1.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public Order getOrderById(Integer id){
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }

    @Transactional
    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    @Transactional
    public Order updateOrder(Integer id, Order updatedOrder) {
        Optional<Order> existingOrderOptional = orderRepository.findById(id);
        if (existingOrderOptional.isPresent()) {
            Order existingOrder = existingOrderOptional.get();

            existingOrder.setNumberOfItems(updatedOrder.getNumberOfItems());
            existingOrder.setStatus(updatedOrder.getStatus());

            return orderRepository.save(existingOrder);
        }
        return null;
    }

    @Transactional
    public void deleteOrder(Integer id){
        orderRepository.deleteById(id);
        }
}
