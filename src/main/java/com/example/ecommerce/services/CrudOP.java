package com.example.ecommerce.services;

import java.util.List;

public interface CrudOP<T> {

    public T save(T t);

    public List<T> findAll();

    public T findById(Long id);

    public T update(T t);

    public void delete(Long id);

}
