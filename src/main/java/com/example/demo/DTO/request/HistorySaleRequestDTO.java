package com.example.demo.DTO.request;

import com.example.demo.models.Pedido;

import java.time.LocalDate;
import java.util.List;

public record HistorySaleRequestDTO(
        String nameofUser,
        List<Long> cards,
        LocalDate dateSale,
        Pedido pedido
) {
}
