package com.enigmacamp.merchant_bank_api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LogoutRequest {
    private String id;
    private String message;

    public LogoutRequest(String message) {
        this.message = message;
    }
}