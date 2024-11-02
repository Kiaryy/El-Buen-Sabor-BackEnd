package com.example.demo.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    private LocalDate lastShipment;
    private double shippingCost;
    private Long phoneNumber;
    
    @ElementCollection
    @CollectionTable(name = "entity_long_list", joinColumns = @JoinColumn(name = "entity_id"))
    @Column(name = "long_value")
    private List<Long> articles;
    
}
