package com.example.demo.service;

import com.example.demo.DTO.request.ArticleRequestDTO;
import com.example.demo.models.ArticleJpa;
import com.example.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService{

    @Autowired
    public ArticleRepository articleInsumoRepository;

    public List<ArticleJpa> getAllArticles() {
        return articleInsumoRepository.findAll();
    }

    public String addArticle(ArticleRequestDTO articleRequestDTO){


        ArticleJpa article = ArticleJpa.builder()
                .name(articleRequestDTO.name())
                .denominacion(articleRequestDTO.denominacion())
                .category(articleRequestDTO.category())
                .provider(articleRequestDTO.provider())
                .priceUnit(articleRequestDTO.priceUnit())
                .precioCompra(articleRequestDTO.precioCompra())
                .stockActual(articleRequestDTO.stockActual())
                .existencies(articleRequestDTO.existencies())
                .lastPurchased(articleRequestDTO.lastPurchased())
                .build();
        // Here we save in dataBase
        articleInsumoRepository.save(article);
        return "Article Added";
    }

    public ArticleJpa update(Long id, ArticleRequestDTO entity){
        Optional<ArticleJpa> entityOptional = articleInsumoRepository.findById(id);
        ArticleJpa article = entityOptional.get();
        // We convert the DTO entity to an object
        article.setName(entity.name());
        article.setDenominacion(entity.denominacion());
        article.setCategory(entity.category());
        article.setProvider(entity.provider());
        article.setPriceUnit(entity.priceUnit());
        article.setPrecioCompra(entity.precioCompra());
        article.setStockActual(entity.stockActual());
        article.setExistencies(entity.existencies());
        article.setLastPurchased(LocalDate.now());
        // Saves updated entity to database
        return articleInsumoRepository.save(article);
    }

    public boolean delete(Long id){
        if(articleInsumoRepository.existsById(id)){
            articleInsumoRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }
}
