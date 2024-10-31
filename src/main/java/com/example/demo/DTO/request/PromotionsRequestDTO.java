package com.example.demo.DTO.request;

import com.example.demo.models.BebidasJpa;
import com.example.demo.models.PlatoJpa;

import java.util.List;

public record PromotionsRequestDTO(
        Double precio,
        List<PlatoJpa> platos,
        List<BebidasJpa> bebidas
) {
}
