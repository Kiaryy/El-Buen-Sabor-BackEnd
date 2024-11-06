package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Promotions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ElementCollection
    private List<PlateReference> platos;
    @ElementCollection
    private List<DrinkReference> bebidas;
    private double precio;
    private boolean available;
    @Lob
    @Column(name = "image_data", columnDefinition="MEDIUMBLOB")
    private byte[] imageData;
}
