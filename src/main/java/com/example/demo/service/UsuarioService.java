package com.example.demo.service;

import com.example.demo.DTO.request.UsuarioRequestDTO;
import com.example.demo.models.UsuarioJpa;
import com.example.demo.repository.UsuarioJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService {
    
    //JPA repository
    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    public UsuarioService(UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }


    public List<UsuarioJpa> getAllUsuarios() {
        return usuarioJpaRepository.findAll();
    }

    public String addUsuarios(UsuarioRequestDTO usuarioDTO) {

        UsuarioJpa usuario = UsuarioJpa.builder()
                .name(usuarioDTO.name())
                .mail(usuarioDTO.mail())
                .address(usuarioDTO.address())
                .passWord(usuarioDTO.passWord())
                .build();
        // Here we save in dataBase
        usuarioJpaRepository.save(usuario);
        return "Usuario agregado";
    }
}
