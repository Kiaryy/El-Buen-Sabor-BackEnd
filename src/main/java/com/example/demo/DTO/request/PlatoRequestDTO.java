package com.example.demo.DTO.request;

import java.util.List;

import com.example.demo.models.ArticleReference;
import com.example.demo.models.enums.Tipo;

public record PlatoRequestDTO(
        String name,
        String description,
        Tipo type,
        Double price,
        int stock,
        byte[] imageData,
        List<ArticleReference> articles
) {
}
