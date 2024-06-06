package com.example.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.ecommerce.models.Order;

public interface OrderDao extends CrudRepository<Order, Long> {

}
