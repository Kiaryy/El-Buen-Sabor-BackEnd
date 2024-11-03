package com.example.demo.service;

import com.example.demo.DTO.request.UsuarioRequestDTO;
import com.example.demo.models.UsuarioJpa;
import com.example.demo.repository.UsuarioJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

        public UsuarioJpa findById(Long id){
        Optional<UsuarioJpa> entityOptional = usuarioJpaRepository.findById(id);
        return entityOptional.get();
    }

    public String addUsuarios(UsuarioRequestDTO usuarioDTO) {

        UsuarioJpa usuario = UsuarioJpa.builder()
                .name(usuarioDTO.name())
                .email(usuarioDTO.mail())
                .addresses(usuarioDTO.addresses())
                .cards(usuarioDTO.cards())
                .phoneNumber(usuarioDTO.phoneNumber())
                .password(usuarioDTO.passWord())
                .build();
        // Here we save in dataBase
        usuarioJpaRepository.save(usuario);
        return "Usuario agregado";
    }

    public UsuarioJpa update(Long id, UsuarioRequestDTO entity){
        Optional<UsuarioJpa> entityOptional = usuarioJpaRepository.findById(id); 
        UsuarioJpa usuario = entityOptional.get();
        // We convert the DTO entity to an object
        usuario.setName(entity.name());
        usuario.setMail(entity.mail());
        usuario.setAddresses(entity.addresses());
        usuario.setCards(entity.cards());
        usuario.setPhoneNumber(entity.phoneNumber());
        usuario.setPassWord(entity.passWord());
        // Saves updated entity to database
        
        return usuarioJpaRepository.save(usuario);
    }

    public boolean delete(Long id){
        if(usuarioJpaRepository.existsById(id)){
            usuarioJpaRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }
}
