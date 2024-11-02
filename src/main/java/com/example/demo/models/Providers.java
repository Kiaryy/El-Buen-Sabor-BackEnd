package com.example.demo.models;

import com.example.demo.models.enums.ProvidersState;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Providers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String product;
    private String lastProduct;
    private double shippingCost;
    private String products;
    private String phoneNumber;
    private ProvidersState state;
}
