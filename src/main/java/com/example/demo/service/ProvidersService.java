package com.example.demo.service;

import com.example.demo.DTO.request.PromotionsRequestDTO;
import com.example.demo.DTO.request.ProvidersRequestDTO;
import com.example.demo.models.Promotions;
import com.example.demo.models.Providers;
import com.example.demo.repository.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvidersService {
    @Autowired
    private ProvidersRepository providersRepository;

    public List<Providers> getAllProviders() {
        return providersRepository.findAll();
    }

    public String addProviders(ProvidersRequestDTO providersDTO) {

        Providers providers = Providers.builder()
                .name(providersDTO.name())
                .state(providersDTO.state())
                .lastProduct(providersDTO.lastProduct())
                .phoneNumber(providersDTO.phoneNumber())
                .product(providersDTO.product())
                .products(providersDTO.products())
                .shippingCost(providersDTO.shippingCost())
                .build();
        providersRepository.save(providers);
        return "Providers added successfully!";
    }

    public Providers updateProviders(Long id, ProvidersRequestDTO entity) {
        Optional<Providers> entityOptional = providersRepository.findById(id);
        Providers providers = entityOptional.get();

        Providers updatedPromotions = Providers.builder()
                .name(entity.name())
                .state(entity.state())
                .lastProduct(entity.lastProduct())
                .phoneNumber(entity.phoneNumber())
                .product(entity.product())
                .products(entity.products())
                .shippingCost(entity.shippingCost())
                .build();
        providers = providersRepository.save(updatedPromotions);
        return providers;
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
