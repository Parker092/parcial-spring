package com.example.ecommerce.responseTypes;

import com.example.ecommerce.models.User;

public class Authenticated {

    public boolean isAuthenticated;
    public User user;

    public Authenticated(boolean isAuthenticated, User user) {
        this.isAuthenticated = isAuthenticated;
        this.user = user;
    }

}
