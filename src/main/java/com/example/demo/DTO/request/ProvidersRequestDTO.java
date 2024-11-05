package com.example.demo.DTO.request;

import java.util.List;

import com.example.demo.models.enums.ArticleCategory;


public record ProvidersRequestDTO(
        String name,
        List<ArticleCategory> product,
        Double shippingCost,
        Long phoneNumber,
        List<Long> articles
) {
}
