package com.example.demo.DTO.request;

import java.util.List;

import com.example.demo.models.Pedido;


public record HistorySaleRequestDTO(
        Long userId,
        List<Long> card,
        Pedido pedido
) {
}
