package com.nie.csd.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "products")
public class Products {

   @Id
   @Field("_id")
    private String id;
    private String name;
    private String description;
    private String category;
    private String tags;
    private float price;
    private int stock;

    public Products() {
    }
    public Products(String id, String name, String description, String category, String tags, float price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.tags = tags;
        this.price = price;
        this.stock = stock;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;       
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;       
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description; 
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category; 
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {  
        this.tags = tags;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Products [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
                + ", tags=" + tags + ", price=" + price + ", stock=" + stock + "]";
    }

}   