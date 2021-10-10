package com.kodluyoruz.homework2solid.service.discount;

import com.kodluyoruz.homework2solid.model.cart.CartItem;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PercentageDiscount implements Discount {
    private final double discountAmount;

    private double getDiscountPercentage() {
        return discountAmount / 100;
    }

    @Override
    public double applyDiscount(CartItem cartItem) {
        double price = cartItem.getProduct().getPrice() * cartItem.getQuantity();
        double appliedDiscount = price * getDiscountPercentage();
        return price - appliedDiscount;
    }
}
