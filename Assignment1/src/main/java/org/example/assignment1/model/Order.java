package org.example.assignment1.model;

import org.springframework.stereotype.Component;

@Component
public class Order {
    private int orderID;
    private int numberOfItems;
    private String Status;


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
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", numberOfItems=" + numberOfItems +
                ", Status='" + Status + '\'' +
                '}';
    }
}
