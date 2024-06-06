package com.example.ecommerce.responseTypes;

import java.util.List;

import com.example.ecommerce.models.Product;

public class OrderDetailsResponse {

    public List<ProductResponse> products;
    public double total;
    public Long orderId;

    public OrderDetailsResponse(List<ProductResponse> products, double total, Long orderId) {
        this.products = products;
        this.total = total;
        this.orderId = orderId;
    }

    public OrderDetailsResponse() {
    }

}
