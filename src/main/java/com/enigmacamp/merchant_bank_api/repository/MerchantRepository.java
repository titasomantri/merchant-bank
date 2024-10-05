package com.enigmacamp.merchant_bank_api.repository;

import com.enigmacamp.merchant_bank_api.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, String> {
}
