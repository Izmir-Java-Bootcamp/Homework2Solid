package com.kodluyoruz.homework2solid.service.discount;

import com.kodluyoruz.homework2solid.model.cart.CartItem;

public interface Discount {
    double applyDiscount(CartItem cartItem);
}
