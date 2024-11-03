package com.example.demo.service;

import com.example.demo.DTO.request.BebidasRequestDTO;
import com.example.demo.models.BebidasJpa;
import com.example.demo.repository.BebidasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BebidasService {
    @Autowired
    private BebidasRepository bebidasRepository;

    public List<BebidasJpa> getAllBebidas() {
        return bebidasRepository.findAll();
    }

    public String addBebidas(BebidasRequestDTO bebidasDTO){


        BebidasJpa bebidasJpa = BebidasJpa.builder()
                .stock(bebidasDTO.stock())
                .descripcion(bebidasDTO.descripcion())
                .precio(bebidasDTO.precio())
                .nombre(bebidasDTO.nombre())
                .build();
        // Here we save in dataBase
        bebidasRepository.save(bebidasJpa);
        return "Article Added";
    }

    public BebidasJpa updatedBebidas(Long id, BebidasRequestDTO entity){
        Optional<BebidasJpa> entityOptional = bebidasRepository.findById(id);
        BebidasJpa bebidasJpa = entityOptional.get();
        // We convert the DTO entity to an object
        bebidasJpa.setDescripcion(entity.descripcion());
        bebidasJpa.setNombre(entity.nombre());
        bebidasJpa.setPrecio(entity.precio());
        bebidasJpa.setStock(entity.stock());
        // Saves updated entity to database
        return bebidasRepository.save(bebidasJpa);
    }

    public boolean deleteBebidas(Long id){
        if(bebidasRepository.existsById(id)){
            bebidasRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }
}
