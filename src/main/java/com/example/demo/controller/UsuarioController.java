package com.example.demo.controller;

import com.example.demo.DTO.request.UsuarioRequestDTO;
import com.example.demo.models.UsuarioJpa;
import com.example.demo.service.UsuarioService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor // with lombok
public class UsuarioController {

    private final UsuarioService usuarioService;
    // Without lombok
    /*
    public PlatoController(PlatosService platosService){
        this.platosService = platosService;
    }
    */
    @GetMapping("/usuarios/findAll")
    List<UsuarioJpa> findAll(){
        return usuarioService.getAllUsuarios();
    }


    @PostMapping("/usuarios/add")
    public ResponseEntity<String> addUsuarios(@RequestBody UsuarioRequestDTO usuarioDTO){

        return ResponseEntity.ok(usuarioService.addUsuarios(usuarioDTO));
    }
}
