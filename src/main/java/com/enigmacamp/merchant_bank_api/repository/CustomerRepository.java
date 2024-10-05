package com.enigmacamp.merchant_bank_api.repository;

import com.enigmacamp.merchant_bank_api.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}