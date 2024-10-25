package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "asiento_contable")
public class AsientoContable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cuenta_id", nullable = false)
    private Cuenta cuenta;
    @Column(nullable = false)
    private LocalDate fecha;
    @Column(nullable = false)
    private double debe;
    @Column(nullable = false)
    private double haber;
    @Builder
    public AsientoContable(Cuenta cuenta, LocalDate fecha, double debe, double haber) {
        this.cuenta = cuenta;
        this.fecha = fecha;
        this.debe = debe;
        this.haber = haber;
    }
    
}
