package com.kodluyoruz.homework2solid.service.writer;

import com.kodluyoruz.homework2solid.model.checkout.Bill;
import com.kodluyoruz.homework2solid.model.enums.BillWriterType;

public interface BillWriter {
    BillWriterType getType();
    void printBill(Bill bill);
}
