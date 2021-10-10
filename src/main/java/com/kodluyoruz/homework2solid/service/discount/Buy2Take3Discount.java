package com.kodluyoruz.homework2solid.service.discount;

import com.kodluyoruz.homework2solid.model.cart.CartItem;

public class Buy2Take3Discount implements Discount {
    @Override
    public double applyDiscount(CartItem cartItem) {
        int discountQuantity = cartItem.getQuantity() / 3;
        int paidQuantity = cartItem.getQuantity() - discountQuantity;
        return paidQuantity * cartItem.getProduct().getPrice();
    }
}
