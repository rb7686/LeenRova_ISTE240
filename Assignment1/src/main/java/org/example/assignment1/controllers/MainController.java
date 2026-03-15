package org.example.assignment1.controllers;

import org.example.assignment1.model.*;
import org.example.assignment1.services.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private MainService mainService;

    public MainController(MainService mainService){this.mainService = mainService;}

    // Landing page handler
    @RequestMapping("/")
    public String getIndex(){
        return "index";
    }

    // GET handler for list of user objects
    @RequestMapping("/user")
    public String getUserList(Model data){
        List<User> userList = this.mainService.findAllUser();
        data.addAttribute("userList", userList);
        return "user";
    }

    // GET handler for user form
    @RequestMapping("/user/add")
    public String getUserForm(){return "userForm";}

    // POST handler to save user data
    @PostMapping("/user/add")
    public String saveUser(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam int phoneNumber, Model data){
        User newUser = new User(id, firstName, lastName, email, phoneNumber, new ArrayList<Order>());
        this.mainService.saveUser((newUser));
        data.addAttribute("entityName", "user");
        return "redirect:/add/success/{entityName}";
    }

    // GET handler for list of order objects
    @RequestMapping("/order")
    public String getorderList(Model data){
        List<Order> orderList = this.mainService.findAllOrder();
        data.addAttribute("orderList", orderList);
        return "order";
    }

    // GET handler for order form
    @RequestMapping("/order/add")
    public String getOrderForm(){return "orderForm";}

    // POST handler to save order data
    @PostMapping("/order/add")
    public String saveOrder(@RequestParam int id, @RequestParam int numberOfItems, @RequestParam String status, @RequestParam String date, @RequestParam User user, Model data){
        Order newOrder = new Order(id, numberOfItems, status, date, user);
        this.mainService.saveOrder((newOrder));
        data.addAttribute("entityName", "order");
        return "redirect:/add/success/{entityName}";
    }

    // GET handler for list of shipping objects
    @RequestMapping("/shipping")
    public String getShippingList(Model data){
        List<Shipping> shippingList = this.mainService.findAllShipping();
        data.addAttribute("shippingList", shippingList);
        return "shipping";
    }

    // GET handler for shipping form
    @RequestMapping("/shipping/add")
    public String getShippingForm(){return "shippingForm";}

    // POST handler to save shipping data
    @PostMapping("/shipping/add")
    public String saveShipping(@RequestParam int shippingID, @RequestParam String homeNumber, @RequestParam String streetName, @RequestParam String city, Model data){
        Shipping newShipping = new Shipping(shippingID, homeNumber, streetName, city);
        this.mainService.saveShipping((newShipping));
        data.addAttribute("entityName", "shipping");
        return "redirect:/add/success/{entityName}";
    }

    // GET handler for list of payment objects
    @RequestMapping("/payment")
    public String getpaymentList(Model data){
        List<Payment> paymentList = this.mainService.findAllPayment();
        data.addAttribute("paymentList", paymentList);
        return "payment";
    }

    // GET handler for payment form
    @RequestMapping("/payment/add")
    public String getPaymentForm(){return "paymentForm";}

    // POST handler to save payment data
    @PostMapping("/payment/add")
    public String savePayment(@RequestParam int paymentID, @RequestParam String paymentMethod, @RequestParam double paymentAmount, @RequestParam String paymentStatus, Model data){
        Payment newPayment = new Payment(paymentID, paymentMethod,paymentAmount, paymentStatus);
        this.mainService.savePayment((newPayment));
        data.addAttribute("entityName", "payment");
        return "redirect:/add/success/{entityName}";
    }

    // GET handler for list of product objects
    @RequestMapping("/product")
    public String getProductList(Model data){
        List<Product> productList = this.mainService.findAllProduct();
        data.addAttribute("productList", productList);
        return "product";
    }

    // GET handler for product form
    @RequestMapping("/product/add")
    public String getProductForm(){return "productForm";}

    // POST handler to save product data
    @PostMapping("/product/add")
    public String saveProduct(@RequestParam int id, @RequestParam String productName, @RequestParam String color, @RequestParam String size,@RequestParam int price, Model data){
        Product newProduct = new Product(id, productName, color, size, price);
        this.mainService.saveProduct((newProduct));
        data.addAttribute("entityName", "product");
        return "redirect:/add/success/{entityName}";
    }

    // Success page handler
    @RequestMapping("/add/success/{entityName}")
    public String getSuccessPage(@PathVariable String entityName, Model data){
        data.addAttribute("entityName", entityName);
        return "success";
    }

}
