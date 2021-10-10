package com.kodluyoruz.homework2solid.service.writer;

import com.kodluyoruz.homework2solid.model.checkout.Bill;
import com.kodluyoruz.homework2solid.model.enums.BillWriterType;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class ConsoleBillWriter implements BillWriter{
    @Override
    public BillWriterType getType() {
        return BillWriterType.CONSOLE;
    }

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
