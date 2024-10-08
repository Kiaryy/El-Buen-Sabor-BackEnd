package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Usuario;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioInitilizerService {
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    public List<Usuario> findAll(){
        return usuarios;
    }
    @PostConstruct
    public void init(){
        usuarios.add(new Usuario("Pedro Gonzales"
            , "pedro.gonzales@gmail.com"
            , "Calle Falsa 123"
            , "123456789"
        ));
        usuarios.add(new Usuario("Manolo Garcia"
            , "manolo.garcia@gmail.com"
            , "Calle Falsa 123"
            , "123456789"
        ));
        usuarios.add(new Usuario("Armando Esteban Quito"
            , "Armando.Quito@gmail.com"
            , "Calle Falsa 123"
            , "123456789"
        ));
    }
}
