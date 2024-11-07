package com.example.demo.service;

import com.example.demo.models.BebidasJpa;
import com.example.demo.repository.BebidasRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BebidasInitializer {

    private final BebidasRepository repository;

    public BebidasInitializer(BebidasRepository repository) {
        this.repository = repository;
    }

    public String deletedBebidas() {
        List<BebidasJpa> all= repository.findAll();
        repository.deleteAll(all);
        return "All articles deleted";
    }
        //  Esta funcion carga un set de bebidas pre definidas
        public List<BebidasJpa> loadBebidas() {
        List<BebidasJpa> bebidas = new ArrayList<>();

        bebidas.add(BebidasJpa.builder()
                .nombre("Coca-Cola")
                .descripcion("Una refrescante Coca-Cola de 1.5L")
                .stock(115)
                .precio(1500.0)
                .build());

        bebidas.add(BebidasJpa.builder()
                .nombre("Coca-Cola Zero")
                .descripcion("Una refrescante Coca-Cola Zero azucares de 1.5L")
                .stock(100)
                .precio(1500.0)
                .build());

        bebidas.add(BebidasJpa.builder()
                .nombre("Sprite")
                .descripcion("Una refrescante Sprite de 1.5L")
                .stock(120)
                .precio(1500.0)
                .build());

        bebidas.add(BebidasJpa.builder()
                .nombre("Fanta")
                .descripcion("Una refrescante Fanta de 1.5L")
                .stock(110)
                .precio(1500.0)
                .build());

        bebidas.add(BebidasJpa.builder()
                .nombre("Fanta Zero")
                .descripcion("Una refrescante Fanta Zero de 1.5L")
                .stock(105)
                .precio(1500.0)
                .build());

        return repository.saveAll(bebidas);
    }
}
