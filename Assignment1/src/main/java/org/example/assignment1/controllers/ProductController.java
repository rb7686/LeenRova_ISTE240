// ROVA BADAVI UID: 761002045
package org.example.assignment1.controllers;

import org.example.assignment1.model.Product;
import org.example.assignment1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts(){ return productService.getAllProducts(); }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @GetMapping("/search")
    public List<Product> getProduct(@RequestParam String productName){
        return productService.getProductByProductName(productName);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
        this.productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product){
        Product updatedProduct = productService.updateProduct(id, product);
        return updatedProduct;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }
}
