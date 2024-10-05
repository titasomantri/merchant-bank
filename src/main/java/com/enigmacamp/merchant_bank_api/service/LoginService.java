package com.enigmacamp.merchant_bank_api.service;

import com.enigmacamp.merchant_bank_api.entity.Customer;
import com.enigmacamp.merchant_bank_api.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    @Autowired
    private CustomerRepository customerRepository;
    public Customer login(String id, String password) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }
        if (!customer.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }
        return customer;
    }
}