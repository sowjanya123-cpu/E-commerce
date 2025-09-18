package com.nie.csd.controllers;
import org.springframework.web.bind.annotation.RestController;

import com.nie.csd.exceptions.IdNotPresentException;
import com.nie.csd.models.Products;
import com.nie.csd.services.ProductService;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProductController {

    Logger logger=LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService service;

    @GetMapping("/hello")   
    public String sayHello(){
        return "hello";
    }



    //retrieve all products
    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllProducts(){
        logger.info("Retrieving all products from the database of collection products from class{}",this.getClass());
        List<Products> productsList= service.getAllProducts();
        return ResponseEntity.ok(productsList);
    }
    //retrieve product by id
    @GetMapping("/products/{id}")
    public ResponseEntity<Products> getByProductId(@PathVariable("id") String id)
    throws IdNotPresentException {
        Products products= service.getByProductId(id);
        return ResponseEntity.ok(products);
        
    }
    //add product to products collection
    @PostMapping("/products")
    public ResponseEntity<Products> addProduct(@RequestBody Products products){
        Products addproducts=service.addProduct(products);
        return ResponseEntity.ok(addproducts);
    }
    //update product by id
    @PutMapping("/products/{id}")
    public Products updateProduct(@PathVariable("id")String id,@RequestBody Products products){
        return service.updateProduct(id,products);
    }
    //delete product by id
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") String id){
        service.deleteProduct(id);
    }

}