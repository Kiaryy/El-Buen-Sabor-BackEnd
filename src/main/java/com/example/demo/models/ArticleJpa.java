package com.example.demo.models;

import java.time.LocalDate;
import com.example.demo.models.enums.ArticleCategory;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleJpa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    private String name;
    private String denominacion;
    private ArticleCategory category;
    private Double priceUnit;
    private Double precioCompra;
    private int stockActual;
    private int existencies;
    private LocalDate lastPurchased;
    private Long provider;
}
