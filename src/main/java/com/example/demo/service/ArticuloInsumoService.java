package com.example.demo.service;

import com.example.demo.models.ArticuloInsumo;
import com.example.demo.repository.ArticuloInsumoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloInsumoService extends BaseService<ArticuloInsumo, Long>{
    public ArticuloInsumoService(ArticuloInsumoRepository articuloInsumoRepository) {
        super(articuloInsumoRepository);
    }

    @Autowired
    public ArticuloInsumoRepository articuloInsumoRepository;

    @Transactional
    public List<ArticuloInsumo> listarPorCategoria(Long idCategoria)throws Exception{
        try {
            return articuloInsumoRepository.findAllByCategoriaId(idCategoria);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
