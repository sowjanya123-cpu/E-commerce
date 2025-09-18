package com.nie.csd.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nie.csd.exceptions.IdNotPresentException;
import com.nie.csd.models.Products;
import com.nie.csd.repositories.ProductRepository;

@Service
public class ProductService {

    Logger logger=LoggerFactory.getLogger(ProductService.class);
    
    @Autowired
    ProductRepository repository;
    //retrieve all products
    public List<Products> getAllProducts(){
        logger.info("Retrieving all products from the database of collection products ");
        return repository.findAll();
    }
    //retrieve product by id
    public Products getByProductId(String id)throws IdNotPresentException {
        logger.debug("Retrieving product with id: {} from the database "
        +"of collection products",id);
          return repository.findById(id)
            .orElseThrow(() -> {
            logger.error("Product not found with id:{} " ,id);
             return new IdNotPresentException("Product not found with id: " + id);  
            });
    }
    //add product to products collection
    public Products addProduct(Products products) {
        logger.info("Adding new product to the database of collection products");
        return repository.save(products);
    }
    //update product by id if exists else add new product
    public Products updateProduct(String id, Products products) {
        Products exProduct=repository.findById(id).get();
        if(exProduct!=null){
            exProduct.setName(products.getName());
            exProduct.setDescription(products.getDescription());
            exProduct.setCategory(products.getCategory());
            exProduct.setTags(products.getTags());
            exProduct.setPrice(products.getPrice());
            exProduct.setStock(products.getStock());
            return repository.save(exProduct);

        }
        return repository.save(products);
    }
    //delete product by id
    public void deleteProduct(String id) {
         Products exProduct=repository.findById(id).get();
         if(exProduct!=null){
            repository.delete(exProduct);
            System.out.println("Product deleted successfully");
         }
            else {
                System.out.println("Product not found");
            }
        
    }

}