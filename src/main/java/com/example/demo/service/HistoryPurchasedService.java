package com.example.demo.service;

import com.example.demo.DTO.request.HistoryPurchaseRequestDTO;
import com.example.demo.models.HistoryPurchased;
import com.example.demo.repository.HistoryPurchasedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryPurchasedService {

    @Autowired
    private HistoryPurchasedRepository historyPurchasedRepository;

    public List<HistoryPurchased> getAllHistoryPurchases() {return historyPurchasedRepository.findAll();}

    public String addHistoryPurchase(HistoryPurchaseRequestDTO historyPurchaseDTO) {

        HistoryPurchased historyPurchased = HistoryPurchased.builder()
                .provider(historyPurchaseDTO.providers())
                .purchaseDate(historyPurchaseDTO.purchaseDate())
                .itemsPurchased(historyPurchaseDTO.itemPurchased())
                .build();
        historyPurchasedRepository.save(historyPurchased);
        return "History purchase added";
    }

    public HistoryPurchased update(Long id, HistoryPurchaseRequestDTO entity) {

        Optional<HistoryPurchased> entityOptional = historyPurchasedRepository.findById(id);
        HistoryPurchased historyPurchased = entityOptional.get();

        HistoryPurchased updatedHistoryPurchased = HistoryPurchased.builder()
                .provider(entity.providers())
                .purchaseDate(entity.purchaseDate())
                .itemsPurchased(entity.itemPurchased())
                .build();
        historyPurchased = historyPurchasedRepository.save(updatedHistoryPurchased);
        return historyPurchased;
    }

    public boolean delete(Long id) {
        if (historyPurchasedRepository.existsById(id)) {
            historyPurchasedRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

}
