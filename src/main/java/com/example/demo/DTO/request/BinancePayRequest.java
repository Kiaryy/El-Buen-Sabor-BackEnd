package com.example.demo.DTO.request;

public record BinancePayRequest(
        String merchantTradeNo,
        double orderAmount,
        String currency,
        String message
){}

