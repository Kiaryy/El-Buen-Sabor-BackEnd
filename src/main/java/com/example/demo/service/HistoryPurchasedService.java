package com.example.demo.service;

import com.example.demo.models.HistoryPurchased;
import com.example.demo.models.Providers;
import com.example.demo.repository.HistoryPurchasedRepository;
import com.example.demo.repository.ProvidersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HistoryPurchasedService {
    @Autowired
    private HistoryPurchasedRepository historyPurchasedRepository;
    @Autowired
    private ProvidersRepository providersRepository;

    public List<HistoryPurchased> getAllHistoryPurchases() {return historyPurchasedRepository.findAll();}

    public String addHistoryPurchase(Long providerId) {
        Optional<Providers> entityOptional = providersRepository.findById(providerId);
        Providers provider = entityOptional.get();
        HistoryPurchased historyPurchased = HistoryPurchased.builder()
                .provider(providerId)
                .purchaseDate(LocalDate.now())
                .product(provider.getProduct())
                .build();
        historyPurchasedRepository.save(historyPurchased);
        return "History purchase added";
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
