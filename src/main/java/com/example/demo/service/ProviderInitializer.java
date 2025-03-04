package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Providers;
import com.example.demo.models.enums.ArticleCategory;
import com.example.demo.repository.ProvidersRepository;

@Service
public class ProviderInitializer {
    private final ProvidersRepository repository;
    @Autowired
    public ProviderInitializer(ProvidersRepository repository) {
        this.repository = repository;
    }
    public String deleteProviders() {
        List<Providers> all= repository.findAll();
        repository.deleteAll(all);
        return "All providers deleted";
    }
    public List<Providers> loadProviders() {
        List<Providers> providers = new ArrayList<>();
        providers.add(Providers.builder()
            .name("BIMBO")
            .phoneNumber(7262401745L)
            .product(List.of(ArticleCategory.PAN))
            .shippingCost(15000D)
            .articles(List.of(29L, 31L))
            .build());
        providers.add(Providers.builder()
            .name("PATTY")
            .phoneNumber(3395992187L)
            .product(List.of(ArticleCategory.CARNE))
            .shippingCost(20000D)
            .articles(List.of(33L,34L,35L,36L,37L,38L))
            .build());
        providers.add(Providers.builder()
            .name("PUREZA")
            .phoneNumber(3812345678L)
            .product(List.of(ArticleCategory.HARINA))
            .shippingCost(10000D)
            .articles(List.of(30L,32L))
            .build());
        providers.add(Providers.builder()
            .name("YAGUAR")
            .phoneNumber(1148921543L)
            .product(List.of(ArticleCategory.VEGETAL))
            .shippingCost(10000D)
            .articles(List.of(1L,2L,3L,4L,5L,6L,7L,8L,9L,10L,11L,12L,13L,14L,15L,22L,23L,25L,26L,27L,28L,47L))
            .build());
        providers.add(Providers.builder()
            .name("ELABASTO")
            .phoneNumber(3417654238L)
            .product(List.of(ArticleCategory.QUESO))
            .shippingCost(15000D)
            .articles(List.of(41L,42L,43L,45L,46L))
            .build());
        providers.add(Providers.builder()
            .name("SERENISIMA")
            .phoneNumber(2234938745L)
            .product(List.of(ArticleCategory.LACTEO))
            .shippingCost(15000D)
            .articles(List.of(20L,39L,40L))
            .build());
        providers.add(Providers.builder()
            .name("KANSAS")
            .phoneNumber(3712187659L)
            .product(List.of(ArticleCategory.SALSA))
            .shippingCost(10000D)
            .articles(List.of(16L,44L))
            .build());
            providers.add(Providers.builder()
            .name("LEDESMA")
            .phoneNumber(1193508264L)
            .product(List.of(ArticleCategory.AZUCAR))
            .shippingCost(20000D)
            .articles(List.of(17L))
            .build());
            providers.add(Providers.builder()
            .name("ABUANA")
            .phoneNumber(2914785329L)
            .product(List.of(ArticleCategory.ESPECIE))
            .shippingCost(10000D)
            .articles(List.of(18L,19L))
            .build());
        providers.add(Providers.builder()
            .name("SAICA")
            .phoneNumber(3518092147L)
            .product(List.of(ArticleCategory.MAICENA))
            .shippingCost(10000L)
            .articles(List.of(21L))
            .build());
        providers.add(Providers.builder()
            .name("LUCCHETTI")
            .phoneNumber(2235432876L)
            .product(List.of(ArticleCategory.CEREAL))
            .shippingCost(15000D)
            .articles(List.of(24L))
            .build());
        return repository.saveAll(providers);
    }
}
