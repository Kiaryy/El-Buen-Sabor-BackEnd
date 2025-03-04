package com.example.demo.controller;

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

    @PostMapping("/historySale/addSale")
    public ResponseEntity<?> addHistorySale(@RequestBody HistorySaleRequestDTO historySaleDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(historySaleService.addHistorySale(historySaleDTO));
    }

    @DeleteMapping("/historySale/{id}")
    // Deletes entity with matching id
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(historySaleService.delete(id));
    }
}
