package com.example.ecommerce.responseTypes;

import com.example.ecommerce.models.Product;

public class ProductResponse {

    public Product product;
    public int quantity;

    public ProductResponse(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductResponse() {
    }

}
