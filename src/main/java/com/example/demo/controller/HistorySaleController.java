package com.example.demo.controller;

import com.example.demo.DTO.request.ArticleRequestDTO;
import com.example.demo.DTO.request.HistorySaleRequestDTO;
import com.example.demo.models.HistorySale;
import com.example.demo.service.HistorySaleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")

public class HistorySaleController {

    private final HistorySaleService historySaleService;

    @GetMapping("/historySale/findAll")
    List<HistorySale> findAll() {return historySaleService.getAllHistorySales();}

    @PostMapping("/historySale/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody HistorySaleRequestDTO historySaleDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(historySaleService.update(id, historySaleDTO));
    }

    @DeleteMapping("/historySale/{id}")
    // Deletes entity with matching id
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(historySaleService.delete(id));
    }
}
