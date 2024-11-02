package com.example.demo.DTO.request;

import java.util.List;


public record ProvidersRequestDTO(
        String name,
        String product,
        Double shippingCost,
        Long phoneNumber,
        List<Long> articles
) {
}
