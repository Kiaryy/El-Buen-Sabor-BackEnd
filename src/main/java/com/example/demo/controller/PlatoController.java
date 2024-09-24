package com.example.demo.controller;

import com.example.demo.DTO.request.PlatoRequestDTO;
import com.example.demo.models.PlatoJpa;
import com.example.demo.service.PlatosService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class PlatoController {

    private final PlatosService platosService;
    // Without lombok
    /*
    public PlatoController(PlatosService platosService){
        this.platosService = platosService;
    }
    */
    @GetMapping("/platos/findAll") 
    // Returns everything in table
    List<PlatoJpa> findAll(){
        return platosService.getAllPlatos();
    }


    @PostMapping("/platos/add")
    // adds DTO object
    public ResponseEntity<String> addPlatos(@RequestBody PlatoRequestDTO platoDTO){ 
        return ResponseEntity.ok(platosService.addPlatos(platoDTO));
    }
    
    @PutMapping("/platos/{id}")
    //Updates entity with matching id
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PlatoRequestDTO platoDTO){ 
        return ResponseEntity.status(HttpStatus.OK).body(platosService.update(id, platoDTO));
    }

    @DeleteMapping("/platos/{id}")
    // Deletes entity with matchign id
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(platosService.delete(id));
    }
}
