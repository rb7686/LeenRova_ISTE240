// Leen Salaheddin Entity UID: 400003496


package org.example.assignment1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {

    // attributes for each user such as ID, first and last name, and contact details
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   @Column
    private String firstName;

   @Column
    private String lastName;

   @Column
    private String email;

   @Column
    private int phoneNumber;

    @OneToMany
    @JsonIgnore
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

    public User() {}
    // getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
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
