package com.example.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.models.User;
import com.example.ecommerce.responseTypes.Authenticated;
import com.example.ecommerce.services.CrudOP;
import com.example.ecommerce.services.UserService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH,
        RequestMethod.DELETE })
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Long id) {
        return this.userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return this.userService.save(user);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User update(@RequestBody User user, @PathVariable Long id) {
        User actualuser = this.userService.findById(id);
        actualuser.setName(user.getName());
        actualuser.setEmail(user.getEmail());
        actualuser.setPassword(user.getPassword());
        return this.userService.save(actualuser);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.userService.delete(id);
    }

    @PostMapping("/login")
    public Authenticated login(@RequestBody User user) {
        return this.userService.login(user.getEmail(), user.getPassword());
    }

}
