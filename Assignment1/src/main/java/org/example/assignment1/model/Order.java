package org.example.assignment1.model;

import org.springframework.stereotype.Component;

//created a bean for our Order class which will be used to store order details

public class Order {

    // attributes relevant to the Order class such as ID, number of items, order status, and order date
    private int orderID;
    private int numberOfItems;
    private String status;
    private String date;
    private User user; // Linking Order to User

    // Constructor
    public Order(int orderID, int numberOfItems, String status, String date, User user) {
        this.orderID = orderID;
        this.numberOfItems = numberOfItems;
        this.status = status;
        this.date = date;
        this.user = user;
    }

    // getters and setters for all attributes
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }
    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // toString function
    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", numberOfItems=" + numberOfItems +
                ", Status='" + status + '\'' +
                '}';
    }
}
