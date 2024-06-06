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

import com.example.ecommerce.models.Category;
import com.example.ecommerce.services.CrudOP;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH,
        RequestMethod.DELETE })
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CrudOP<Category> cartService;

    @GetMapping
    public List<Category> getAll() {
        return this.cartService.findAll();
    }

    @GetMapping("/{id}")
    public Category getOne(@PathVariable Long id) {
        return this.cartService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category save(@RequestBody Category cart) {
        return this.cartService.save(cart);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category update(@RequestBody Category cart, @PathVariable Long id) {
        Category actualcart = this.cartService.findById(id);
        actualcart.setName(cart.getName());
        return this.cartService.save(actualcart);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.cartService.delete(id);
    }

}
