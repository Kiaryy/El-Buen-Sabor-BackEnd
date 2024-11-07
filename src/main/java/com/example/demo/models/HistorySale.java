package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistorySale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long card;
    private LocalDate dateSale;

    @OneToOne
    @JoinColumn(name = "historial_pedido_id")
    private Pedido pedido;
}
