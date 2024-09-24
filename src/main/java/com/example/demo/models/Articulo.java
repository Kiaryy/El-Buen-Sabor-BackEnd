package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Articulo extends Base{

    protected String denominacion;

    @ManyToOne
    @JoinColumn(name = "categoriaId")
    protected Categoria categoria;

    protected Double precioVenta;
}
