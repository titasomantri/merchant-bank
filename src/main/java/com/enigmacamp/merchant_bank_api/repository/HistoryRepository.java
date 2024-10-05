package com.enigmacamp.merchant_bank_api.repository;

import com.enigmacamp.merchant_bank_api.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
}
