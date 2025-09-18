package com.nie.csd.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nie.csd.models.Products;
@Repository
public interface ProductRepository extends MongoRepository<Products,String>{

}