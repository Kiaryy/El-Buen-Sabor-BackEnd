package com.example.demo.DTO.request;

public record userPreferenceRequest(
        String title,
        int quantity,
        String description,
        String price
){}
