package com.kodluyoruz.homework2solid.service.payment;

import com.kodluyoruz.homework2solid.model.checkout.Bill;

public interface Payment {
    boolean isAcceptable(Bill bill);
    void pay(Bill bill);
}
