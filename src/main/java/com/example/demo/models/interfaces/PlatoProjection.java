package com.example.demo.models.interfaces;

import com.example.demo.models.ArticleReference;
import com.example.demo.models.enums.Tipo;
import java.util.List;

public interface PlatoProjection {
    Long getPlatoId();
    String getName();
    String getDescription();
    Tipo getType();
    Double getPrice();
    int getStock();
    boolean isAvailable();
    int getTimesPurchased();
    List<ArticleReference> getArticles();
}