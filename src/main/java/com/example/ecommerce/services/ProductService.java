package com.example.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.models.Product;

@Service
public class ProductService implements CrudOP<Product> {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product save(Product t) {
        return productDao.save(t);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productDao.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productDao.findById(id).get();
    }

    @Override
    public Product update(Product t) {
        return productDao.save(t);
    }

    @Override
    public void delete(Long id) {
        productDao.deleteById(id);
    }

    public List<Product> findByName(String name) {
        return productDao.findByName(name);
    }

}
