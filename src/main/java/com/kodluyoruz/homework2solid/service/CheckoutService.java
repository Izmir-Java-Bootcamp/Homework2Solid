package com.kodluyoruz.homework2solid.service;

import com.kodluyoruz.homework2solid.model.cart.Cart;
import com.kodluyoruz.homework2solid.model.checkout.Bill;
import com.kodluyoruz.homework2solid.model.checkout.BillItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckoutService {
    public Bill checkout(Cart cart) {
        List<BillItem> billItems = cart.getCartItems()
                .stream()
                .map(cartItem -> BillItem.builder()
                        .productName(cartItem.getProduct().getName())
                        .quantity(cartItem.getQuantity())
                        .sellerName(cartItem.getSeller().getName())
                        .price(cartItem.getPrice())
                        .discountedPrice(cartItem.getDiscountedPrice())
                        .build())
                .collect(Collectors.toList());
        double totalSum = billItems.stream()
                .map(BillItem::getDiscountedPrice)
                .mapToDouble(d -> d)
                .sum();

        return Bill.builder()
                .billItems(billItems)
                .totalPrice(totalSum)
                .build();
    }
}
