package org.example.assignment1.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// created a User bean that stores user related information

public class User {

    // attributes for each user such as ID, first and last name, and contact details
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private List<Order> orders; //linking to User

    // Constructor
    public User(int id, String firstName, String lastName, String email, int phoneNumber, List<Order> orders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.orders = orders;
    }

    // getters and setters
    public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // toString function
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
