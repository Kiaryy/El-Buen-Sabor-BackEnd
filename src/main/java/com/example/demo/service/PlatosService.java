package com.example.demo.service;

import com.example.demo.DTO.request.PlatoRequestDTO;
import com.example.demo.models.ArticleJpa;
import com.example.demo.models.ArticleReference;
import com.example.demo.models.PlatoJpa;
import com.example.demo.models.interfaces.PlatoProjection;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.PlatoJpaRepository;

import jakarta.transaction.Transactional;

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
    @Autowired
    private ArticleRepository articleRepository;

    //JPA repository

    public List<PlatoJpa> getAllPlatos() {
        return platoJpaRepository.findAll();
    }
    public List<PlatoProjection> findAllProjected() {
    return platoJpaRepository.findAllProjected();
}

    public PlatoJpa findById(Long id){
        Optional<PlatoJpa> entityOptional = platoJpaRepository.findById(id);
        return entityOptional.get();
    }
    @Transactional
    public String addPlatos(PlatoRequestDTO platoDTO){
        PlatoJpa plato = PlatoJpa.builder()
            .name(platoDTO.name())
            .description(platoDTO.description())
            .price(platoDTO.price())
            .type(platoDTO.type())
            .stock(platoDTO.stock())
            .available(platoDTO.available())
            .imageData(platoDTO.imageData())
            .articles(platoDTO.articles())
            .build();
    
        platoJpaRepository.save(plato);
        return "Plato agregado";
    }

    public PlatoJpa update(Long id, PlatoRequestDTO entity){
        Optional<PlatoJpa> entityOptional = platoJpaRepository.findById(id); 
        PlatoJpa plato = entityOptional.get();
        // We convert the DTO entity to an object
        plato.setName(entity.name());
        plato.setDescription(entity.description());
        plato.setPrice(entity.price());
        plato.setType(entity.type());
        plato.setStock(entity.stock());
        plato.setAvailable(entity.available());
        plato.setImageData(entity.imageData());
        plato.setArticles(entity.articles());
        // Saves updated entity to database
        return platoJpaRepository.save(plato);
    }
    @Transactional
    public String purchasePlate(Long platoId, int quantity) {

        PlatoJpa plato = platoJpaRepository.findById(platoId).orElse(null);

        if (plato == null) {
            return "Plato no encontrado.";
        }

        // Verificar si hay suficiente stock
        if (plato.getStock() < quantity) {
            return "No hay suficiente stock disponible.";
        }
        for (ArticleReference article : plato.getArticles()) {
            Optional<ArticleJpa> articleOptional = articleRepository.findById(article.getArticleId());
            ArticleJpa articleJpa = articleOptional.get();
            articleJpa.setStockActual(articleJpa.getStockActual() - quantity*article.getQuantity());
            articleRepository.save(articleJpa);
        }
        // Reducir el stock del plato
        plato.setStock(plato.getStock() - quantity);
        // Aumentar el contador de compras
        plato.setTimesPurchased(plato.getTimesPurchased() + quantity);
        // Save Plate
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
