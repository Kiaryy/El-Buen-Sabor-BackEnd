package com.example.demo.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "pedido")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;
    //private List<PlatoJpa> productos;
    @ElementCollection
    private List<PlateReference> productos;
    private String nombreDelivery;
    // private String idDelivery;

    private String user;
}
