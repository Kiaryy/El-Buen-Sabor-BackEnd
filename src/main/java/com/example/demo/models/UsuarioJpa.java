package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioJpa extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String mail;
    private ArrayList<String> addresses;
    private ArrayList<Long> cards ;
    private String passWord;

    @OneToMany(mappedBy = "user" ,cascade =CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedido;

}