package com.enigmacamp.merchant_bank_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
