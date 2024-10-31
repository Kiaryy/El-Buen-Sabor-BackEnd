package com.example.demo.DTO.request;

public record BebidasRequestDTO(
        String nombre,
        String descripcion,
        double precio,
        int stock
) {
}
