package com.example.demo.repository;

import com.example.demo.models.HistorySale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorySaleRepository extends JpaRepository<HistorySale, Long> {
}
