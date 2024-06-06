package com.example.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.dao.UserDao;
import com.example.ecommerce.models.User;
import com.example.ecommerce.responseTypes.Authenticated;

@Service
public class UserService implements CrudOP<User> {
    @Autowired
    private UserDao userDao;

    @Override
    public User save(User t) {
        return userDao.save(t);
    }

    @Override
    public List<User> findAll() {

        return (List<User>) userDao.findAll();
    }

    @Override
    public User findById(Long id) {

        return userDao.findById(id).get();
    }

    @Override
    public User update(User t) {
        return userDao.save(t);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    public Authenticated login(String email, String password) {
        User user = userDao.login(email, password);
        if (user != null) {
            return new Authenticated(true, user);
        }
        return new Authenticated(false, null);
    }

}
