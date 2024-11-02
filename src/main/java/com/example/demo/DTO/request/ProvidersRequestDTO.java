package com.example.demo.DTO.request;

import com.example.demo.models.enums.ProvidersState;

public record ProvidersRequestDTO(
        String name,
        String product,
        String lastProduct,
        Double shippingCost,
        String products,
        String phoneNumber,
        ProvidersState state
) {
}
