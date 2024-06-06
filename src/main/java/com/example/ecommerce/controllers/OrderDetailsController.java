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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.models.OrderDetails;
import com.example.ecommerce.responseTypes.OrderDetailsResponse;
import com.example.ecommerce.services.CrudOP;
import com.example.ecommerce.services.OrderDetailsService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH,
        RequestMethod.DELETE })
@RequestMapping("/api/details")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderService;

    @GetMapping
    public List<OrderDetails> getAll() {
        return this.orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderDetailsResponse getByOrder(@PathVariable Long id) {
        return this.orderService.findByOrder(id);
    }

    @GetMapping("/client/{name}")
    public OrderDetailsResponse getByClientName(@PathVariable String name) {
        return this.orderService.findByClientName(name);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public OrderDetails save(@RequestBody OrderDetails od) {
        return this.orderService.save(od);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public OrderDetails update(@RequestBody OrderDetails od, @PathVariable Long id) {
        OrderDetails actualOrderDetails = this.orderService.findById(id);
        actualOrderDetails.setOrder(od.getOrder());
        actualOrderDetails.setProduct(od.getProduct());
        actualOrderDetails.setQuantity(od.getQuantity());

        return this.orderService.save(actualOrderDetails);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.orderService.delete(id);
    }

}
