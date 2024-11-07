package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.models.enums.ArticleCategory;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoryPurchased {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long provider;
    private LocalDate purchaseDate;
    @ElementCollection
    private List<ArticleCategory> product;

}
