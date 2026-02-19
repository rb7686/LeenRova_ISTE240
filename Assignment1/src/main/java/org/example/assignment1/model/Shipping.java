package org.example.assignment1.model;

import org.springframework.stereotype.Component;

@Component
public class Shipping {
    private int shippingID;
    private String homeNumber;
    private String streetName;
    private String city;

    public int getShippingID() {
        return shippingID;
    }
    public void setShippingID(int shippingID) {
        this.shippingID = shippingID;
    }

    public String getHomeNumber() {
        return homeNumber;
    }
    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getStreetName() {
        return streetName;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "shippingID=" + shippingID +
                ", homeNumber='" + homeNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
