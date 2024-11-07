package com.example.demo.DTO.request;

import com.example.demo.models.Pedido;


public record HistorySaleRequestDTO(
        Long userId,
        Long card,
        Pedido pedido
) {
}
