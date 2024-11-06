package com.example.demo.DTO.request;


import java.util.List;

import com.example.demo.models.DrinkReference;
import com.example.demo.models.PlateReference;

public record PromotionsRequestDTO(
        String name,
        Double precio,
        byte[] imageData,
        boolean available,
        List<PlateReference> platos,
        List<DrinkReference> bebidas
) {
}
