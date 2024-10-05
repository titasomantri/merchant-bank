package com.enigmacamp.merchant_bank_api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PaymentRequest {
    private String customerId;
    private double amount;
    private String merchantId;
}
