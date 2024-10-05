package com.enigmacamp.merchant_bank_api.controller;

import com.enigmacamp.merchant_bank_api.service.LogoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logout")
@RequiredArgsConstructor
public class LogoutController {
    private final LogoutService logoutService;

    @PostMapping
    public String logout(@RequestBody String token) {
        return logoutService.logout(token);
    }
}