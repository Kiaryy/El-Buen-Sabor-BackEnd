package com.example.demo.repository;

import com.example.demo.models.BebidasJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidasRepository extends JpaRepository<BebidasJpa, Long> {
}
