package com.tutorial.distributecache.controller;

import com.tutorial.distributecache.entities.Product;
import com.tutorial.distributecache.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @PostMapping
    public Product save(@RequestBody Product product){
        return this.productService.save(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return this.productService.findById(id);
    }

    @PatchMapping("/{id}/{price}")
    public Product updatePrice(@PathVariable Long id, @PathVariable float price){
        return this.productService.updatePrice(id,price);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
         this.productService.deleteById(id);
    }

}
