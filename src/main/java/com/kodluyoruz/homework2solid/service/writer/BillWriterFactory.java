package com.kodluyoruz.homework2solid.service.writer;

import com.kodluyoruz.homework2solid.model.enums.BillWriterType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BillWriterFactory {
    private final Map<BillWriterType, BillWriter> billWriterMap;

    public BillWriterFactory(List<BillWriter> billWriters) {
        this.billWriterMap = billWriters.stream()
                .collect(Collectors.toMap(BillWriter::getType, billWriter -> billWriter));
    }

    public BillWriter getBillWriter(BillWriterType type) {
        return billWriterMap.get(type);
    }
}
