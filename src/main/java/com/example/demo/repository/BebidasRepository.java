package com.example.demo.repository;

import com.example.demo.models.BebidasJpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidasRepository extends JpaRepository<BebidasJpa, Long> {
    @Query(value = "SELECT * FROM bebidas_jpa WHERE nombre=?",nativeQuery = true)
        public Optional<BebidasJpa> findByName(String name);
}
