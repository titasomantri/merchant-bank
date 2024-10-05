package com.enigmacamp.merchant_bank_api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {
    private String id;
    private String password;
}
