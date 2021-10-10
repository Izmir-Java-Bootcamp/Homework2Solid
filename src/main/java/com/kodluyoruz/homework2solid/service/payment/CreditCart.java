package com.kodluyoruz.homework2solid.service.payment;

import com.kodluyoruz.homework2solid.model.checkout.Bill;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CreditCart implements Payment {
    @Override
    public boolean isAcceptable(Bill bill) {
        return bill.getTotalPrice() >= 1000;
    }

    @Override
    public void pay(Bill bill) {
        double commission = bill.getTotalPrice() * 0.01;
        double price = bill.getTotalPrice() + commission;

        System.out.printf("Credit Cart payment completed." +
                "Commission charge: %s " +
                "Commision Rate: %s" +
                "Payment After commission: %s", commission, 0.01, price);
    }
}
