package com.example.demo.models;

import com.example.demo.models.enums.Tipo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

//With Lombok
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlatoJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long platoId;

    private String name;
    private String description;
    private Tipo type;
    private Double price;
    private int stock;
    private boolean avaliable;
    private String img;
}
