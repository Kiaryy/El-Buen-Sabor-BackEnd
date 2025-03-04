package com.example.demo.service;

import com.example.demo.DTO.request.ProvidersRequestDTO;
import com.example.demo.models.ArticleJpa;
import com.example.demo.models.Providers;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProvidersService {
    @Autowired
    private ProvidersRepository providersRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private HistoryPurchasedService historyPurchasedService;

    public List<Providers> getAllProviders() {
        return providersRepository.findAll();
    }

    public String addProviders(ProvidersRequestDTO providersDTO) {

        Providers providers = Providers.builder()
                .name(providersDTO.name())
                .lastShipment(null)
                .phoneNumber(providersDTO.phoneNumber())
                .product(providersDTO.product())
                .shippingCost(providersDTO.shippingCost())
                .articles(providersDTO.articles())
                .build();
        providersRepository.save(providers);
        return "Provider added successfully!";
    }

    public String purchaseArticles(Long id){
        Optional<Providers> entityOptional = providersRepository.findById(id);
        Providers provider = entityOptional.get();
        LocalDate currentDate = LocalDate.now();
        provider.setLastShipment(currentDate);
        for (Long articleId : provider.getArticles()) {
            Optional<ArticleJpa> articleOptional = articleRepository.findById(articleId);
            ArticleJpa articleJpa = articleOptional.get();
            articleJpa.setStockActual(articleJpa.getStockActual() + 50);
            articleJpa.setLastPurchased(currentDate);
            articleRepository.save(articleJpa);
        }
        historyPurchasedService.addHistoryPurchase(id);
        return "Articles Purchased";
    }

    public Providers updateProviders(Long id, ProvidersRequestDTO entity){
        Optional<Providers> entityOptional = providersRepository.findById(id);
        Providers providers = entityOptional.get();
        providers.setName(entity.name());
        providers.setLastShipment(null);
        providers.setPhoneNumber(entity.phoneNumber());
        providers.setProduct(entity.product());
        providers.setShippingCost(entity.shippingCost());
        providers.setArticles(entity.articles());
        return providersRepository.save(providers);
    }

    public boolean delete(Long id){
        if(providersRepository.existsById(id)){
            providersRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }


}
