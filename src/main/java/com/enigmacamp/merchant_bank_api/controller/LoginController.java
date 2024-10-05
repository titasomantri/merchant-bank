package com.enigmacamp.merchant_bank_api.controller;

import com.enigmacamp.merchant_bank_api.dto.LoginRequest;
import com.enigmacamp.merchant_bank_api.entity.Customer;
import com.enigmacamp.merchant_bank_api.service.LoginService;
import com.enigmacamp.merchant_bank_api.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Customer customer = loginService.login(loginRequest.getId(), loginRequest.getPassword());
        if (customer != null) {
            String json = JsonUtil.toJson(customer);
            return new ResponseEntity<>(json, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }
}