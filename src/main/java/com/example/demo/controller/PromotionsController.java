package com.example.demo.controller;

import com.example.demo.DTO.request.PromotionsRequestDTO;
import com.example.demo.models.Promotions;
import com.example.demo.service.PromotionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PromotionsController {

    private final PromotionsService promotionsService;

    @GetMapping("/promotions/findAll")
        // Returns everything in table
    List<Promotions> findAll(){
        return promotionsService.getAllPromotions();
    }

    @PostMapping("/promotions/add")
    // adds DTO object
    public ResponseEntity<String> addArticle(@RequestBody PromotionsRequestDTO promotionsDTO){
        return ResponseEntity.ok(promotionsService.addPromotion(promotionsDTO));
    }

    @PutMapping("/promotions/{id}")
    // Updates entity with matching id
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody PromotionsRequestDTO promotionsDTO){
        return ResponseEntity.status(HttpStatus.OK).body(promotionsService.updatePromotion(id, promotionsDTO));
    }

    @DeleteMapping("/promotions/{id}")
    // Deletes entity with matching id
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(promotionsService.delete(id));
    }
    @PostMapping("/promotions/purchasePromotion/{id}/{quantity}")
    public String purchasePromotion(@PathVariable("id") Long id, @PathVariable("quantity")int quantity) {
        return promotionsService.purchasePromotion(id, quantity);
    }
}

