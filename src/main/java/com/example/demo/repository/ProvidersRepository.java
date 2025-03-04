package com.example.demo.repository;

import com.example.demo.models.Providers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidersRepository extends JpaRepository<Providers, Long> {
}
