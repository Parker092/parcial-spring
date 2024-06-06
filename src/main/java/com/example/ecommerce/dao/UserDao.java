package com.example.ecommerce.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.ecommerce.models.User;
import com.example.ecommerce.responseTypes.Authenticated;

public interface UserDao extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
    public User login(String email, String password);

}
