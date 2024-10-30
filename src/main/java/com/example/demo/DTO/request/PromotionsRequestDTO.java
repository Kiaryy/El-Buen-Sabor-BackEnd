package com.example.demo.DTO.request;

import java.util.List;

public record PromotionsRequestDTO(
        Double precio,
        List<String> platos,
        List<String> bebidas
) {
}
