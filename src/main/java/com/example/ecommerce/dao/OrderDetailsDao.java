package com.example.ecommerce.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryRewriter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.models.OrderDetails;

import jakarta.persistence.PostPersist;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.transaction.Transactional;

public interface OrderDetailsDao extends CrudRepository<OrderDetails, Long> {

    @Query("SELECT od FROM OrderDetails od WHERE od.order.id = ?1")
    public List<OrderDetails> findByOrder(Long id);

    @Query("SELECT od FROM OrderDetails od WHERE od.order.user.name = ?1")
    public List<OrderDetails> findByClientName(String name);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.stock = :nuevoStock WHERE p.id = :id")
    public void updateStock(@Param("nuevoStock") int nuevoStock, @Param("id") Long id);

}
