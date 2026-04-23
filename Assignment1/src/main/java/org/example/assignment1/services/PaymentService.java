// ROVA BADAVI UID: 761002045
package org.example.assignment1.services;

import jakarta.transaction.Transactional;
import org.example.assignment1.model.Payment;
import org.example.assignment1.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // get payment entity by ID
    public Payment getPaymentById(Integer id){
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.orElse(null);
    }

    // get payment entity by payment method attribute
    public List<Payment> getPaymentByPaymentMethod(String paymentMethod){
        return paymentRepository.findByPaymentMethod(paymentMethod);
    }

    // get all payment entities
    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    // creating a payment
    @Transactional
    public Payment createPayment(Payment payment){
        return paymentRepository.save(payment);
    }

    // updating the payment's status attribute
    @Transactional
    public Payment updatePayment(Integer id, Payment updatedPayment){
        Optional<Payment> existingPaymentOptional = paymentRepository.findById(id);
        if (existingPaymentOptional.isPresent()) {
            Payment existingPayment = existingPaymentOptional.get();

            existingPayment.setPaymentStatus(updatedPayment.getPaymentStatus());

            return paymentRepository.save(existingPayment);
        }
        return null;
    }

    // delete a payment by id
    @Transactional
    public void deletePayment(Integer id){
        paymentRepository.deleteById(id);
    }
}
