// ROVA BADAVI UID:761002045
package org.example.assignment1.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

//created a bean for our product class
@Entity
@Table(name = "PRODUCT")
public class Product {

    //created our attributes that are related to our product class
    // the products we have will have attributes that are suitable for them
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String productName;

    @Column
    private String color;

    @Column
    private String size;

    @Column
    private int price;

    //Constructor

    public Product(int id, String productName, String color, String size, int price) {
        this.id = id;
        this.productName = productName;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public Product(){}

    //made the getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    //the toString function
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}
