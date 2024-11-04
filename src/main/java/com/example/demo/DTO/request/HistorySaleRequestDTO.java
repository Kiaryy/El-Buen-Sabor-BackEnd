package com.example.demo.DTO.request;

import com.example.demo.models.Pedido;

import java.util.List;

public record HistorySaleRequestDTO(
        String nameofUser,
        List<Long> cards,
        Pedido pedido
) {
}
