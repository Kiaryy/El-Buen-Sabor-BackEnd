package com.example.demo.DTO.request;

public record QuoteInquiryDTO(
        String fromAsset,
        String toAsset,
        double fromAmount
) {
}
