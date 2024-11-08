package com.example.demo.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@DiscriminatorValue("U")
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioJpa extends Person {
    private String mail ;
    @ElementCollection
    private List<String> addresses;
    @ElementCollection
    private List<Long> cards ;
    private String passWord;

    @ElementCollection
    private List<Pedido> pedido;

    @Builder
    public UsuarioJpa(String name, Long phoneNumber, String email, List<String> addresses, List<Long> cards,
            String password, List<Pedido> pedido) {
        super(name, phoneNumber);
        this.mail = email;
        this.addresses = addresses;
        this.cards = cards;
        this.passWord = password;
        this.pedido = pedido;
    }

    
}