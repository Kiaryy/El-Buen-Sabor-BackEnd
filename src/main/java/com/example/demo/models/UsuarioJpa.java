package com.example.demo.models;

import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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