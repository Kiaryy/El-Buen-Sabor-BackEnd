package com.example.demo.service;

import com.example.demo.DTO.request.PromotionsRequestDTO;
import com.example.demo.models.Promotions;
import com.example.demo.repository.PromotionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionsService {
    @Autowired
    private PromotionsRepository promotionsRepository;


    public List<Promotions> getAllPromotions() {
        return promotionsRepository.findAll();
    }

    public String addPromotion(PromotionsRequestDTO promotionsDTO) {

        Promotions promotions = Promotions.builder()
                .platos(promotionsDTO.platos())
                .bebidas(promotionsDTO.bebidas())
                .precio(promotionsDTO.precio())
                .build();
        promotionsRepository.save(promotions);
        return "Promotions added successfully!";
    }

    public Promotions updatePromotion(Long id, PromotionsRequestDTO entity) {
        Optional<Promotions> entityOptional = promotionsRepository.findById(id);
        Promotions promotions = entityOptional.get();

        Promotions updatedPromotions = Promotions.builder()
                .precio(entity.precio())
                .bebidas(entity.bebidas())
                .platos(entity.platos())
                .build();
        promotions = promotionsRepository.save(updatedPromotions);
        return promotions;
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
