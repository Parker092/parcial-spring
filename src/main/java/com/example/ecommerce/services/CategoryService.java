package com.example.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dao.CategoryDao;
import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.models.Category;

@Service
public class CategoryService implements CrudOP<Category> {
    @Autowired
    private CategoryDao cartDao;

    @Override
    public Category save(Category t) {
        return cartDao.save(t);

    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) cartDao.findAll();
    }

    @Override
    public Category findById(Long id) {
        return cartDao.findById(id).get();
    }

    @Override
    public Category update(Category t) {
        return cartDao.save(t);

    }

    @Override
    public void delete(Long id) {
        cartDao.deleteById(id);
    }

}
