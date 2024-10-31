package com.example.demo.models.interfaces;

import java.util.List;

import com.example.demo.models.ArticleReference;
import com.example.demo.models.enums.Tipo;

public interface PlateProjection {
    String getName();
    String getDescription();
    Tipo getType();
    Double getPrice();
    Integer getStock();
    Boolean getAvaliable();
    Integer getTimesPurchased();
    List<ArticleReference> getArticles();

}
