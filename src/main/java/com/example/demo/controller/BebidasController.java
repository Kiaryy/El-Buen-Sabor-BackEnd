package com.example.demo.controller;

import com.example.demo.DTO.request.BebidasRequestDTO;
import com.example.demo.models.BebidasJpa;
import com.example.demo.service.BebidasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class BebidasController {

    private final BebidasService bebidasService;

    @GetMapping("/bebidas/findAll")
    List<BebidasJpa> findAll(){
        return bebidasService.getAllBebidas();
    }

    @PostMapping("/bebidas/add")
    // adds DTO object
    public ResponseEntity<String> addArticle(@RequestBody BebidasRequestDTO bebidasDTO){
        return ResponseEntity.ok(bebidasService.addBebidas(bebidasDTO));
    }

    @PutMapping("/bebidas/{id}")
    // Updates entity with matching id
    public ResponseEntity<?> updatedBebidas(@PathVariable Long id, @RequestBody BebidasRequestDTO bebidasDTO){
        return ResponseEntity.status(HttpStatus.OK).body(bebidasService.updatedBebidas(id, bebidasDTO));
    }

    @DeleteMapping("/bebidas/{id}")
    // Deletes entity with matching id
    public ResponseEntity<?> deleteBebidas(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bebidasService.deleteBebidas(id));
    }
}
