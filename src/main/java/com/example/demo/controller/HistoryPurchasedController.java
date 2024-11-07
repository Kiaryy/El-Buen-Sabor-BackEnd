package com.example.demo.controller;

import com.example.demo.models.HistoryPurchased;
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
    public ResponseEntity<?> addHistoryPurchase(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(historyPurchasedService.addHistoryPurchase(id));
    }

    @DeleteMapping("/historypurchased/{id}")
    // Deletes entity with matching id
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(historyPurchasedService.delete(id));
    }
}
