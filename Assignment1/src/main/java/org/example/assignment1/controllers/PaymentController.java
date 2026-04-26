// ROVA BADAVI UID:761002045
package org.example.assignment1.controllers;

import org.example.assignment1.model.Payment;
import org.example.assignment1.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/all")
    public List<Payment> getAllPayments(){ return paymentService.getAllPayments(); }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Integer id){
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/search")
    public List<Payment> getPaymentMethod(@RequestParam String paymentMethod){
        return paymentService.getPaymentByPaymentMethod(paymentMethod);
    }

    @PostMapping
    public void addPayment(@RequestBody Payment payment){
        this.paymentService.createPayment(payment);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Integer id, @RequestBody Payment payment){
        Payment updatedPayment = paymentService.updatePayment(id, payment);
        return updatedPayment;
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Integer id){
        paymentService.deletePayment(id);
    }
}
