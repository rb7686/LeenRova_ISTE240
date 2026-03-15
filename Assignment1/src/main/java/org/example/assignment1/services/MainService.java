package org.example.assignment1.services;

import org.example.assignment1.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //this class acts as a data manager/repository and includes lists of relevant objects
public class MainService {
    List<Order> orderList = new ArrayList<Order>();
    List<Payment> paymentList = new ArrayList<Payment>();
    List<Product> productList = new ArrayList<Product>();
    List<Shipping> shippingList = new ArrayList<Shipping>();
    List<User> userList = new ArrayList<User>();

    public MainService(){

        // seeding users
        var user1 = new User(1, "Rova", "Badavi", "rb7686@rit.edu", 971, new ArrayList<Order>());
        var user2 = new User(2, "Leen", "Salaheddin", "lns2566@rit.edu", 971, new ArrayList<Order>());

        this.userList.add(user1);
        this.userList.add(user2);

        // seeding orders
        var order1 = new Order(1, 1, "Delivered", "1/3/2025", user1);
        var order2 = new Order(2, 1, "Processing", "2/3/2025", user2);

        this.orderList.add(order1);
        this.orderList.add(order2);

        // seeding products
        var product1 = new Product(1, "Gloves", "white", "M", 50);
        var product2 = new Product(2, "Shoes", "pink", "S", 45);

        this.productList.add(product1);
        this.productList.add(product2);

        // seeding payments
        var payment1 = new Payment(1, "Debit card", 55.00, "Pending");
        var payment2 = new Payment(2, "Cash", 100.00, "Completed");

        this.paymentList.add(payment1);
        this.paymentList.add(payment2);

        // seeding shipping
        var shipping1 = new Shipping(1, "15", "Silicon Oasis", "Dubai");
        var shipping2 = new Shipping(2, "82", "Business Bay", "Dubai");

        this.shippingList.add(shipping1);
        this.shippingList.add(shipping2);
    }

    // functions that return the full list of each entity
    public List<User> findAllUser(){return this.userList;}
    public List<Order> findAllOrder(){return this.orderList;}
    public List<Product> findAllProduct(){return this.productList;}
    public List<Shipping> findAllShipping(){return this.shippingList;}
    public List<Payment> findAllPayment(){return this.paymentList;}

    // functions that add a new object to each entity list
    public void saveUser(User user){this.userList.add(user);}
    public void saveOrder(Order order){this.orderList.add(order);}
    public void saveProduct(Product product){this.productList.add(product);}
    public void saveShipping(Shipping shipping){this.shippingList.add(shipping);}
    public void savePayment(Payment payment){this.paymentList.add(payment);}

}
