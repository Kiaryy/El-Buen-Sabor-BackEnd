package com.example.demo.repository;

import com.example.demo.models.ArticuloInsumo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long>{

    List<ArticuloInsumo> findAllByCategoriaId(Long idCategoria);
}
