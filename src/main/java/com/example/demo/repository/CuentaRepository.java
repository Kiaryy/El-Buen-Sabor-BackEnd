package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.example.demo.models.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    Optional<Cuenta> findByNombre(String nombre);
}
