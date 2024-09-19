package com.example.demo.service;

import com.example.demo.DTO.request.PlatoRequestDTO;
import com.example.demo.models.PlatoJpa;
import com.example.demo.models.enums.Tipo;
import com.example.demo.repository.PlatoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlatosService {
    @Autowired
    private PlatoJpaRepository platoJpaRepository;


    public PlatosService(PlatoJpaRepository platoJpaRepository) {
        this.platoJpaRepository = platoJpaRepository;
    }

    //JPA repository

    public List<PlatoJpa> getAllPlatos() {
        return platoJpaRepository.findAll();
    }

    public String addPlatos(PlatoRequestDTO platoDTO) {

        PlatoJpa plato = PlatoJpa.builder()
                .name(platoDTO.name())
                .description(platoDTO.description())
                .price(platoDTO.price())
                .type(Tipo.BEBIDA)
                .stock(platoDTO.stock())
                .avaliable(true)
                .img(platoDTO.img())
                .build();
        // Here we save in dataBase
        platoJpaRepository.save(plato);
        return "Plato agregado";
    }
}
