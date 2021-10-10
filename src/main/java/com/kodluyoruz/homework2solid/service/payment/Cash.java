package com.kodluyoruz.homework2solid.service.payment;

import com.kodluyoruz.homework2solid.model.checkout.Bill;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class Cash implements Payment {
    @Override
    public boolean isAcceptable(Bill bill) {
        return true;
    }

    @Override
    public void pay(Bill bill) {
        System.out.println("Payment completed with cash, Total Price: " + bill.getTotalPrice());
    }
}
