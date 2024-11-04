package com.example.demo.DTO.request;

import java.util.List;

public record HistoryPurchaseRequestDTO(
        Long provider,
        List<String> itemPurchased
) {
}
