package com.kodluyoruz.homework2solid.model.checkout;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Bill {
    private List<BillItem> billItems;
    private double totalPrice;
}
