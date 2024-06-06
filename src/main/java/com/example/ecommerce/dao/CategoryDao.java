package com.example.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.ecommerce.models.Category;

public interface CategoryDao extends CrudRepository<Category, Long> {

}
