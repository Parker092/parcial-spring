package com.example.ecommerce.dao;

import java.util.List;

import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.models.Product;

public interface ProductDao extends CrudRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    public List<Product> findByName(String name);

    /*
     * @SQLUpdate(sql = "UPDATE product SET stock = :newStock WHERE id = :id")
     * void updateStock(@Param("newStock") int newStock, @Param("id") Long id);
     */

}
