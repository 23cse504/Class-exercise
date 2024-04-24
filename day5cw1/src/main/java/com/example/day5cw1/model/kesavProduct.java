package com.example.day5cw1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class kesavProduct {
    @Id
    private int productId;
    private String productName;
    private String productDescription;
    public kesavProduct() {
    }
    public kesavProduct(int productId, String productName, String productDescription) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    
}
