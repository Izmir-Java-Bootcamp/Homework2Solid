package com.kodluyoruz.homework2solid.model.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public void addItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
