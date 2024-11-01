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
    @ManyToOne
    @JoinColumn(name = "cuenta2_id", nullable = false)
    private Cuenta cuenta2;
    @Column(nullable = false)
    private double debe2;
    @Column(nullable = false)
    private double haber2;
    @Builder
    public AsientoContable(Cuenta cuenta, LocalDate fecha, double debe, double haber, Cuenta cuenta2, double debe2,
            double haber2) {
        this.cuenta = cuenta;
        this.fecha = fecha;
        this.debe = debe;
        this.haber = haber;
        this.cuenta2 = cuenta2;
        this.debe2 = debe2;
        this.haber2 = haber2;
    }
    
    

    
}
