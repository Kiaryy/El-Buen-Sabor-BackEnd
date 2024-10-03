package com.example.demo.controller;

import com.example.demo.DTO.request.UsuarioRequestDTO;
import com.example.demo.models.UsuarioJpa;
import com.example.demo.service.UsuarioService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/usuarios/findAll")
    List<UsuarioJpa> findAll(){
        return usuarioService.getAllUsuarios();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/usuarios/add")
    public ResponseEntity<String> addUsuarios(@RequestBody UsuarioRequestDTO usuarioDTO){

        return ResponseEntity.ok(usuarioService.addUsuarios(usuarioDTO));
    }
    
    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/usuarios/{id}")
    //Updates entity with matching id
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UsuarioRequestDTO usuarioDTO){ 
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.update(id, usuarioDTO));
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/usuarios/{id}")
    // Deletes entity with matchign id
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(usuarioService.delete(id));
    }
}
