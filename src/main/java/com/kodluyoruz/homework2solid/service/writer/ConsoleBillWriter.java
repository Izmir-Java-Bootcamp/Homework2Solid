package com.kodluyoruz.homework2solid.service.writer;

import com.kodluyoruz.homework2solid.model.checkout.Bill;
import org.springframework.stereotype.Component;

@Component
public class ConsoleBillWriter implements BillWriter{
    @Override
    public void printBill(Bill bill) {
        System.out.println("ProductName" + "\t" +
                "SellerName" + "\t" +
                "Quantity" + "\t" +
                "Price" + "\t" +
                "Discounted Price");

        bill.getBillItems().forEach(billItem -> {
            System.out.println(billItem.getProductName() + "\t" +
                    billItem.getSellerName() + "\t" +
                    billItem.getQuantity() + "\t" +
                    billItem.getPrice() + "\t" +
                    billItem.getDiscountedPrice());
        });
        System.out.println("Total Price: " + bill.getTotalPrice());
    }
}
