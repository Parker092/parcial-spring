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

import com.example.ecommerce.models.Product;
import com.example.ecommerce.services.CrudOP;
import com.example.ecommerce.services.ProductService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH,
        RequestMethod.DELETE })
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id) {
        return this.productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product save(@RequestBody Product product) {
        return this.productService.save(product);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product update(@RequestBody Product product, @PathVariable Long id) {
        Product actualProduct = this.productService.findById(id);
        actualProduct.setName(product.getName());
        actualProduct.setPrice(product.getPrice());
        actualProduct.setStock(product.getStock());
        actualProduct.setCategory(product.getCategory());
        actualProduct.setDescription(product.getDescription());
        actualProduct.setImage(product.getImage());
        return this.productService.save(actualProduct);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.productService.delete(id);
    }

    @GetMapping("/search/{name}")
    public List<Product> findByName(@PathVariable String name) {
        return this.productService.findByName(name);
    }

}
