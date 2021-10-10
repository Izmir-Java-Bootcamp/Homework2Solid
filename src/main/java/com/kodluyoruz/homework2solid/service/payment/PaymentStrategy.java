package com.kodluyoruz.homework2solid.service.payment;

import com.kodluyoruz.homework2solid.model.checkout.Bill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentStrategy {
    private final List<Payment> payments;

    public void pay(Bill bill) {
        payments.stream()
                .filter(payment -> payment.isAcceptable(bill))
                .findFirst()
                .ifPresent(p ->
                        p.pay(bill));
    }
}
