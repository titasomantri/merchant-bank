package com.enigmacamp.merchant_bank_api.service;

import com.enigmacamp.merchant_bank_api.entity.Customer;
import com.enigmacamp.merchant_bank_api.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutService {
    private CustomerRepository customerRepository;
    public String logout(String id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            // update the customer's status to "logged out"
            customer.setStatus("logged out");
            customerRepository.save(customer);
            System.out.println("User " + id + " has logged out");
        } else {
            System.out.println("User " + id + " not found");
        }
        return id;
    }
}