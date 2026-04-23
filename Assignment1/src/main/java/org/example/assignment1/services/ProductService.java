// ROVA BADAVI UID: 761002045
package org.example.assignment1.services;

import jakarta.transaction.Transactional;
import org.example.assignment1.model.Product;
import org.example.assignment1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // Inserting the product repository into the service
    @Autowired
    private ProductRepository productRepository;

    // get product entity by id
    public Product getProductById(Integer id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    // get products by name
    public List<Product> getProductByProductName(String productName){
        return productRepository.findByProductName(productName);
    }

    // get all products
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    // creating a new product
    @Transactional
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    // updating a product's attributes
    @Transactional
    public Product updateProduct(Integer id, Product updatedProduct){
        Optional<Product> existingProductOptional = productRepository.findById(id);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setColor(updatedProduct.getColor());
            existingProduct.setSize(updatedProduct.getSize());

            return productRepository.save(existingProduct);
        }
        return null;
    }

    // delete a product by id
    @Transactional
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}