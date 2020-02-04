package com.codelean.service;

import com.codelean.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static Map<Long, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(new Long(1), new Customer(1, "Kathy", "Kathy@gmail.com", "Ha Noi"));
        customers.put(new Long(2), new Customer(2, "Jonh", "Jonh@gmail.com", "Ha Noi"));
        customers.put(new Long(3), new Customer(3, "Bin", "Bin@gmail.com", "Ha Noi"));
        customers.put(new Long(4), new Customer(4, "Bop", "Bop@gmail.com", "Ha Noi"));
        customers.put(new Long(5), new Customer(5, "Ted", "Ted@gmail.com", "Ha Noi"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer save(Customer customer) {
        customers.put(customer.getId(), customer);
        return customer;
    }

    @Override
    public Customer findById(long id) {
        return customers.get(id);
    }

    @Override
    public void update(long id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void remove(long id) {
        customers.remove(id);
    }
}
