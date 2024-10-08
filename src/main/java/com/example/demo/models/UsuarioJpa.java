package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioJpa extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String mail;
    private ArrayList<String> adresses = new ArrayList<String>();
    private ArrayList<Long> cards = new ArrayList<Long>();
    private String passWord;

    @OneToMany(mappedBy = "user" ,cascade =CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedido = new ArrayList<>();

    @Builder
    public UsuarioJpa(String name, Long phoneNumber, Long usuarioId, String mail, ArrayList<String> addresses, ArrayList<Long> cards, String passWord) {
        super(name, phoneNumber);
        this.userId = usuarioId;
        this.adresses = addresses;
        this.cards = cards;
        this.mail = mail;
        this.passWord = passWord;
    }
}