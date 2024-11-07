package com.example.demo.DTO.request;

import java.time.LocalDate;

import com.example.demo.models.enums.ArticleCategory;

public record ArticleRequestDTO(
        String name,
        ArticleCategory category,
        Long provider,
        Double priceUnit,
        Double precioCompra,
        int stockActual,
        int existencies,
        LocalDate lastPurchased
) {
}

