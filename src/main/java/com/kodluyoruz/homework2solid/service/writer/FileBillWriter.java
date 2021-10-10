package com.kodluyoruz.homework2solid.service.writer;

import com.kodluyoruz.homework2solid.model.checkout.Bill;
import com.kodluyoruz.homework2solid.model.enums.BillWriterType;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Primary
public class FileBillWriter implements BillWriter {
    @Override
    public BillWriterType getType() {
        return BillWriterType.FILE;
    }

    @Override
    public void printBill(Bill bill) {
        String header = "ProductName" + "\t" +
                "SellerName" + "\t" +
                "Quantity" + "\t" +
                "Price" + "\t" +
                "Discounted Price";

        List<String> billItems = bill.getBillItems().stream()
                .map(billItem ->
                        billItem.getProductName() + "\t" +
                                billItem.getSellerName() + "\t" +
                                billItem.getQuantity() + "\t" +
                                billItem.getPrice() + "\t" +
                                billItem.getDiscountedPrice()
                ).collect(Collectors.toList());
        String totalPrice = "Total Price: " + bill.getTotalPrice();
        System.out.println("FileWriter");
    }
}
