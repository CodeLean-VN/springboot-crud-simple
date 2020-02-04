package com.codelean.controller;


import com.codelean.model.Customer;
import com.codelean.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer retrieveStudent(@PathVariable long id) {
        return customerService.findById(id);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerService.remove(id);
    }

    @PostMapping("/customers")
    public ResponseEntity<Object> createStudent(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.save(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCustomer.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer, @PathVariable long id) {
        customer.setId(id);
        customerService.save(customer);
        return ResponseEntity.noContent().build();
    }
}
