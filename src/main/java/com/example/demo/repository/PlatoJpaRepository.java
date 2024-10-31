package com.example.demo.repository;

import com.example.demo.models.PlatoJpa;
import com.example.demo.models.interfaces.PlateProjection;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoJpaRepository extends JpaRepository<PlatoJpa, Long> {
    //Busca si existen los nombres de los platos ingresado
    @Query("SELECT CASE " +
            "WHEN COUNT(*) > 0 THEN true " +
            "ELSE false END " +
            "FROM PlatoJpa p WHERE p.name = :producto")
    boolean existsByName(@Param("producto") String producto);
    @Query("SELECT p.name AS name, p.description AS description, p.type AS type, p.price AS price, " +
            "p.stock AS stock, p.available AS available, p.timesPurchased AS timesPurchased, p.articles AS articles " +
            "FROM PlatoJpa p")
    List<PlateProjection> findAllPlatesSimple();
}
