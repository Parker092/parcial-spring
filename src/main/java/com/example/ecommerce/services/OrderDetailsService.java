package com.example.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.example.ecommerce.dao.OrderDetailsDao;
import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.models.OrderDetails;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.responseTypes.OrderDetailsResponse;
import com.example.ecommerce.responseTypes.ProductResponse;

@Service
public class OrderDetailsService implements CrudOP<OrderDetails> {

    @Autowired
    private OrderDetailsDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public OrderDetails save(OrderDetails t) {
        Product product = productDao.findById(t.getProduct().getId()).get();
        this.orderDao.updateStock(product.getStock() - t.getQuantity(), product.getId());
        return orderDao.save(t);
    }

    @Override
    public List<OrderDetails> findAll() {
        return (List<OrderDetails>) orderDao.findAll();
    }

    @Override
    public OrderDetails findById(Long id) {
        return orderDao.findById(id).get();
    }

    public OrderDetailsResponse findByOrder(Long id) {
        List<OrderDetails> details = orderDao.findByOrder(id);
        List<ProductResponse> products = new ArrayList<>();

        double total = 0;
        for (OrderDetails orderDetails : details) {
            products.add(new ProductResponse(orderDetails.getProduct(), orderDetails.getQuantity()));
            total += orderDetails.getProduct().getPrice() * orderDetails.getQuantity();

        }
        return new OrderDetailsResponse(products, total, id);
    }

    public OrderDetailsResponse findByClientName(String name) {
        List<OrderDetails> details = orderDao.findByClientName(name);
        List<ProductResponse> products = new ArrayList<>();

        double total = 0;
        for (OrderDetails orderDetails : details) {
            products.add(new ProductResponse(orderDetails.getProduct(), orderDetails.getQuantity()));
            total += orderDetails.getProduct().getPrice() * orderDetails.getQuantity();

        }
        return new OrderDetailsResponse(products, total, details.get(0).getOrder().getId());
    }

    @Override
    public OrderDetails update(OrderDetails t) {
        return orderDao.save(t);
    }

    @Override
    public void delete(Long id) {
        orderDao.deleteById(id);
    }

}
