package com.example.demo.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.request.AsientoRequestDTO;
import com.example.demo.DTO.request.CuentaRequestDTO;
import com.example.demo.models.AsientoContable;
import com.example.demo.models.Cuenta;
import com.example.demo.service.ContabilidadService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/contabilidad")
@CrossOrigin(origins = "*")
public class ContabilidadController {

    @Autowired
    private ContabilidadService contabilidadService;

    // Registra un asiento con el id de la cuenta, debe y haber.
    @PostMapping("/registrar-asiento")
    public ResponseEntity<?> registrarAsiento(@RequestBody AsientoRequestDTO asientoDTO) {
        contabilidadService.registrarAsiento(asientoDTO);
        return ResponseEntity.ok("Asiento registrado con éxito");
    }

    // Añadir una cuenta
    //! No usar
    @PostMapping("/addCuenta")
    public ResponseEntity<?> addCuenta(@RequestBody CuentaRequestDTO cuentaDTO) {
        contabilidadService.crearCuenta(cuentaDTO);
        return ResponseEntity.ok("Cuenta creada con exito");
    }
    // Devuelve el saldo de una cuenta
    @GetMapping("/saldo")
    public ResponseEntity<Double> obtenerSaldo(@RequestBody String cuenta) {
        double saldo = contabilidadService.obtenerSaldo(cuenta);
        return ResponseEntity.ok(saldo);
    }
    // Devuelve los asientos contables
    @GetMapping("/findAsientos")
    List<AsientoContable> findAllAsientos(){
        return contabilidadService.getAllAsientosContables();
    }
    
    // Devuelve las cuentas
    @GetMapping("/findCuentas")
    List<Cuenta> findAllCuentas(){
        return contabilidadService.getAllCuentas();
    }
}
