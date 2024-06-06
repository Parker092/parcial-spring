package com.example.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dao.OrderDao;
import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.models.Order;

@Service
public class OrderService implements CrudOP<Order> {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order save(Order t) {
        return orderDao.save(t);
    }

    @Override
    public List<Order> findAll() {
        return (List<Order>) orderDao.findAll();
    }

    @Override
    public Order findById(Long id) {

        return orderDao.findById(id).get();

    }

    @Override
    public Order update(Order t) {
        return orderDao.save(t);
    }

    @Override
    public void delete(Long id) {
        orderDao.deleteById(id);
    }

}
