package com.example.demo.DTO.request;

import com.example.demo.models.enums.Providers;

import java.time.LocalDate;
import java.util.List;

public record HistoryPurchaseRequestDTO(
        Providers providers,
        LocalDate purchaseDate,
        List<String> itemPurchased
) {
}
