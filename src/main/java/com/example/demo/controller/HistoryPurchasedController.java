package com.example.demo.controller;

import com.example.demo.DTO.request.HistoryPurchaseRequestDTO;
import com.example.demo.DTO.request.HistorySaleRequestDTO;
import com.example.demo.models.HistoryPurchased;
import com.example.demo.models.HistorySale;
import com.example.demo.service.HistoryPurchasedService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class HistoryPurchasedController {

    private final HistoryPurchasedService historyPurchasedService;

    @GetMapping("/historypurchased/findAll")
    List<HistoryPurchased> findAll() {return historyPurchasedService.getAllHistoryPurchases();}

    @PostMapping("/historypurchased/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody HistoryPurchaseRequestDTO historyPurchaseDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(historyPurchasedService.update(id, historyPurchaseDTO));
    }

    @DeleteMapping("/historypurchased/{id}")
    // Deletes entity with matching id
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(historyPurchasedService.delete(id));
    }
}
