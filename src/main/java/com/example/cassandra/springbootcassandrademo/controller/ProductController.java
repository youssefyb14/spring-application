package com.example.cassandra.springbootcassandrademo.controller;


import com.example.cassandra.springbootcassandrademo.ResouceNotFoundException;
import com.example.cassandra.springbootcassandrademo.model.Product;
import com.example.cassandra.springbootcassandrademo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200") 
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        productRepository.save(product);
        return product;

    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Integer productId){
        Product product=productRepository.findById(productId).orElseThrow(
                () -> new ResouceNotFoundException("Product not found" + productId));
        return ResponseEntity.ok().body(product);
    }



    @GetMapping("/products")
    public List<Product> getProducts(){

        return productRepository.findAll();
    }


    @DeleteMapping("products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") Integer productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResouceNotFoundException("Product not found::: " + productId));
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }

}


