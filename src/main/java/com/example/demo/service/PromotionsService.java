package com.example.demo.service;

import com.example.demo.DTO.request.PromotionsRequestDTO;
import com.example.demo.models.ArticleJpa;
import com.example.demo.models.ArticleReference;
import com.example.demo.models.BebidasJpa;
import com.example.demo.models.DrinkReference;
import com.example.demo.models.PlateReference;
import com.example.demo.models.PlatoJpa;
import com.example.demo.models.Promotions;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.BebidasRepository;
import com.example.demo.repository.PlatoJpaRepository;
import com.example.demo.repository.PromotionsRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionsService {
    @Autowired
    private PromotionsRepository promotionsRepository;
    @Autowired
    private PlatoJpaRepository platoJpaRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private BebidasRepository bebidasRepository;


    public List<Promotions> getAllPromotions() {
        return promotionsRepository.findAll();
    }

    public String addPromotion(PromotionsRequestDTO promotionsDTO) {

        Promotions promotions = Promotions.builder()
                .name(promotionsDTO.name())
                .precio(promotionsDTO.precio())
                .imageData(promotionsDTO.imageData())
                .available(promotionsDTO.available())
                .platos(promotionsDTO.platos())
                .bebidas(promotionsDTO.bebidas())
                .build();
        promotionsRepository.save(promotions);
        return "Promotions added successfully!";
    }

    public Promotions updatePromotion(Long id, PromotionsRequestDTO entity) {
        Optional<Promotions> entityOptional = promotionsRepository.findById(id);
        Promotions promotions = entityOptional.get();
        promotions.setName(entity.name());
        promotions.setPrecio(entity.precio());
        promotions.setImageData(entity.imageData());
        promotions.setAvailable(entity.available());
        promotions.setBebidas(entity.bebidas());
        promotions.setPlatos(entity.platos());
        return promotionsRepository.save(promotions);
    }
    @Transactional
    public String purchasePromotion(Long id, int quantity){
        Optional<Promotions> entityOptional = promotionsRepository.findById(id); 
        Promotions promotion = entityOptional.get();
        // Logic to handle plate and ingredient stock
        for (PlateReference platoRef : promotion.getPlatos()) {
            Optional<PlatoJpa> platoOptional = platoJpaRepository.findByName(platoRef.getPlateName());
            PlatoJpa plato = platoOptional.get();
            // Reducing plate stock by one
            plato.setStock(plato.getStock() - quantity);
            // Reduce ingredients stock from plate
            for (ArticleReference article : plato.getArticles()) {
                Optional<ArticleJpa> articleOptional = articleRepository.findById(article.getArticleId());
                ArticleJpa articleJpa = articleOptional.get();
                articleJpa.setStockActual(articleJpa.getStockActual() -quantity*article.getQuantity());
                articleRepository.save(articleJpa);
            }
            platoJpaRepository.save(plato);
        }
        // Logic to handle drink stock
        for (DrinkReference drink : promotion.getBebidas()) {
            Optional<BebidasJpa> bebidOptional = bebidasRepository.findByName(drink.getPlateName());
            BebidasJpa drinkJpa = bebidOptional.get();
            drinkJpa.setStock(drinkJpa.getStock() - quantity);
            bebidasRepository.save(drinkJpa);
        }
        return "Promotion Purchased successfully";
    }

    public boolean delete(Long id){
        if(promotionsRepository.existsById(id)){
            promotionsRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }
}
