package com.example.demo.controller;

import com.example.demo.DTO.request.ProvidersRequestDTO;
import com.example.demo.models.Providers;
import com.example.demo.service.ProvidersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ProvidersController {

    private final ProvidersService providerService;

    @GetMapping("/providers/findAll")
    // Returns everything in table
    List<Providers> findAll(){
        return providerService.getAllProviders();
    }

    @PostMapping("/providers/add")
    // adds DTO object
    public ResponseEntity<String> addProvider(@RequestBody ProvidersRequestDTO providersDTO){
        return ResponseEntity.ok(providerService.addProviders(providersDTO));
    }
    @PostMapping("/providers/purchase/{id}")
    public ResponseEntity<String> purchaseArticles(@PathVariable("id") Long id){
        return ResponseEntity.ok(providerService.purchaseArticles(id));
    }

    @PutMapping("/providers/{id}")
    // Updates entity with matching id
    public ResponseEntity<?> updateProvider(@PathVariable("id") Long id, @RequestBody ProvidersRequestDTO providersDTO){
        return ResponseEntity.status(HttpStatus.OK).body(providerService.updateProviders(id, providersDTO));
    }

    @DeleteMapping("/providers/{id}")
    // Deletes entity with matching id
    public ResponseEntity<?> deleteProvider(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(providerService.delete(id));
    }
}
