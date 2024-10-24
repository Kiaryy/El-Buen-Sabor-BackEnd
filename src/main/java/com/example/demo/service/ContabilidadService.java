package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.request.AsientoRequestDTO;
import com.example.demo.DTO.request.CuentaRequestDTO;
import com.example.demo.models.AsientoContable;
import com.example.demo.models.Cuenta;
import com.example.demo.repository.AsientoContableRepository;
import com.example.demo.repository.CuentaRepository;
import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

import jakarta.transaction.Transactional;

@Service
public class ContabilidadService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private AsientoContableRepository asientoContableRepository;

    @Transactional
    public void registrarAsiento(AsientoRequestDTO asientoDTO) {
        // Buscar la cuenta por nombre
        Cuenta cuenta = cuentaRepository.findByNombre(asientoDTO.cuenta())
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        
        // Crear el asiento contable
        AsientoContable asiento = AsientoContable.builder()
            .cuenta(cuenta)
            .fecha(LocalDate.now())
            .debe(asientoDTO.debe())
            .haber(asientoDTO.haber())
            .build();
        // Guardar el asiento contable
        asientoContableRepository.save(asiento);
        
        // Actualizar el saldo de la cuenta
        double nuevoSaldo = cuenta.getSaldo() + (asientoDTO.haber() - asientoDTO.debe());
        cuenta.setSaldo(nuevoSaldo);
        
        // Guardar la cuenta con el nuevo saldo
        cuentaRepository.save(cuenta);
    }
    
    public List<AsientoContable> getAllAsientosContables(){
        return asientoContableRepository.findAll();
    }
    
    public List<Cuenta> getAllCuentas(){
        return cuentaRepository.findAll();
    }
    
    public Cuenta crearCuenta(CuentaRequestDTO cuentaDTO) {
        // Verifica si la cuenta ya existe
        Optional<Cuenta> cuentaExistente = cuentaRepository.findByNombre(cuentaDTO.nombre());
        if (cuentaExistente.isPresent()) {
            throw new RuntimeException("La cuenta ya existe");
        }
        
        // Crea una nueva cuenta
        Cuenta nuevaCuenta = Cuenta.builder()
            .nombre(cuentaDTO.nombre())
            .saldo(0)
            .build();
        // Guarda la cuenta en la base de datos
        return cuentaRepository.save(nuevaCuenta);
    }
    
    public double obtenerSaldo(String nombreCuenta) {
        Cuenta cuenta = cuentaRepository.findByNombre(nombreCuenta)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        return cuenta.getSaldo();
    }
}
