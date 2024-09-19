package com.example.demo.repository;


import com.example.demo.models.Categoria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria, Long>{

    List<Categoria> findAllByCategoriaPadreId(Long idCategoriaPadre);



}
