package com.kodluyoruz.homework2solid.model.cart;

import com.kodluyoruz.homework2solid.model.Product;
import com.kodluyoruz.homework2solid.model.Seller;
import com.kodluyoruz.homework2solid.service.discount.Discount;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItem {
    private Product product;
    private int quantity;
    private Seller seller;
    private Discount discount;

    public double getPrice() {
        return product.getPrice() * quantity;
    }

    public double getDiscountedPrice() {
        if (discount != null) {
            return discount.applyDiscount(this);
        }
        return getPrice();
    }
}
