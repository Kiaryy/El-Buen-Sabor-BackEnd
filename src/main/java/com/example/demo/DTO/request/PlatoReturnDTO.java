package com.example.demo.DTO.request;

import com.example.demo.models.enums.Tipo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlatoReturnDTO {
    private String name;
    private String description;
    private Tipo type;
    private Double price;
    private int stock;
    private boolean available;
    private byte[] imageData;
    private int timesPurchased;
}
