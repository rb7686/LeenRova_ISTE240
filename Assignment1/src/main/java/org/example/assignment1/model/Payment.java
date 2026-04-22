// ROVA BADAVI UID:761002045
package org.example.assignment1.model;

import jakarta.persistence.*;

//created a bean for our payment class which will be used to make the user have a simple payment experience
@Entity
@Table(name = "PAYMENT")
public class Payment {

    //created our attributes that are related to our payment class with appropriate data types
    // the payment class will have attributes that are needed
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentID;

    @Column
    private String paymentMethod;

    @Column
    private double paymentAmount;

    @Column
    private String paymentStatus;

    // Constructor

    public Payment(int paymentID, String paymentMethod, double paymentAmount, String paymentStatus) {
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
    }

    public Payment(){}

    //made the getters and setters
    public int getPaymentID() {
        return paymentID;
    }
    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }
    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    //the toString function
    @Override
    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}

