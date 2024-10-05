package com.enigmacamp.merchant_bank_api.controller;

import com.enigmacamp.merchant_bank_api.dto.PaymentRequest;
import com.enigmacamp.merchant_bank_api.dto.LogoutRequest;
import com.enigmacamp.merchant_bank_api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class PaymentController {
    private final PaymentService paymentService;
    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processPayment() {
        Scanner scanner = new Scanner(System.in);
        // Masukkan detail pembayaran
        System.out.println("Enter customer ID: ");
        String customerId = scanner.nextLine();
        System.out.println("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        // Buat PaymentRequest dan set data
        PaymentRequest request = new PaymentRequest();
        request.setCustomerId(customerId);
        request.setAmount(amount);
        // Proses pembayaran dengan PaymentService
        LogoutRequest response = paymentService.processPayment(request);
        System.out.println(response.getMessage());
    }
}

