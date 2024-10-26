package com.example.demo.service;

import com.example.demo.DTO.request.PlatoRequestDTO;
import com.example.demo.models.PlatoJpa;
import com.example.demo.repository.PlatoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PlatosService {

    private final PlatoJpaRepository platoJpaRepository;
    @Autowired
    public PlatosService(PlatoJpaRepository platoJpaRepository) {

        this.platoJpaRepository = platoJpaRepository;
    }

    //JPA repository

    public List<PlatoJpa> getAllPlatos() {
        return platoJpaRepository.findAll();
    }

    public PlatoJpa findById(Long id){
        Optional<PlatoJpa> entityOptional = platoJpaRepository.findById(id);
        return entityOptional.get();
    }

    public String addPlatos(PlatoRequestDTO platoDTO){


        PlatoJpa plato = PlatoJpa.builder()
                .name(platoDTO.name())
                .description(platoDTO.description())
                .price(platoDTO.price())
                .type(platoDTO.type())
                .stock(platoDTO.stock())
                .available(true)
                .imageData(platoDTO.imageData())
                .build();
        // Here we save in dataBase
        platoJpaRepository.save(plato);
        return "Plato agregado";
    }

    public PlatoJpa update(Long id, PlatoRequestDTO entity){
        Optional<PlatoJpa> entityOptional = platoJpaRepository.findById(id); 
        PlatoJpa plato = entityOptional.get();
        // We convert the DTO entity to an object
        PlatoJpa platoActualizado = PlatoJpa.builder()
                .platoId(id)
                .name(entity.name())
                .description(entity.description())
                .price(entity.price())
                .type(entity.type())
                .stock(entity.stock())
                .available(true)
                .imageData(entity.imageData())
                .build();
        // Saves updated entity to database
        plato = platoJpaRepository.save(platoActualizado);
        return plato;
    }

    public String purchasePlate(Long platoId, int quantity) {

        PlatoJpa plato = platoJpaRepository.findById(platoId).orElse(null);

        if (plato == null) {
            return "Plato no encontrado.";
        }

        // Verificar si hay suficiente stock
        if (plato.getStock() < quantity) {
            return "No hay suficiente stock disponible.";
        }

        // Reducir el stock del plato
        plato.setStock(plato.getStock() - quantity);

        // Aumentar el contador de compras
        plato.setTimesPurchased(plato.getTimesPurchased() + quantity);

        platoJpaRepository.save(plato);

        return "Compra realizada exitosamente. Se compraron " + quantity + " unidades del plato " + plato.getName() + ".";
    }

    public boolean delete(Long id){
        if(platoJpaRepository.existsById(id)){
            platoJpaRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }
}
