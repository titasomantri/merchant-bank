package com.enigmacamp.merchant_bank_api.service;

import com.enigmacamp.merchant_bank_api.dto.LogoutRequest;
import com.enigmacamp.merchant_bank_api.dto.PaymentRequest;
import com.enigmacamp.merchant_bank_api.entity.Customer;
import com.enigmacamp.merchant_bank_api.entity.History;
import com.enigmacamp.merchant_bank_api.entity.Merchant;
import com.enigmacamp.merchant_bank_api.repository.CustomerRepository;
import com.enigmacamp.merchant_bank_api.repository.HistoryRepository;
import com.enigmacamp.merchant_bank_api.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private CustomerRepository customerRepository;
    private MerchantRepository merchantRepository;
    private HistoryRepository historyRepository;

    public LogoutRequest processPayment(PaymentRequest paymentRequest) {
        Customer customer = customerRepository.findById(paymentRequest.getCustomerId()).orElse(null);
        Merchant merchant = merchantRepository.findById(paymentRequest.getMerchantId()).orElse(null);

        if (customer != null && merchant != null) {
            if (customer.getBalance() >= paymentRequest.getAmount()) {
                customer.setBalance(customer.getBalance() - paymentRequest.getAmount());
                customerRepository.save(customer);
                History history = new History(null, paymentRequest.getCustomerId(), paymentRequest.getMerchantId(), "payment", paymentRequest.getAmount());
                historyRepository.save(history);
                return new LogoutRequest("Payment successful");
            } else {
                return new LogoutRequest("Insufficient balance");
            }
        } else {
            return new LogoutRequest("Customer or merchant not found");
        }
    }
}
