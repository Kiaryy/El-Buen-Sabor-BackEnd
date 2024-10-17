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
    private String email ;
    private List<String> addresses;
    private List<Long> cards ;
    private String password;

    @OneToMany(mappedBy = "user" ,cascade =CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedido;

    @Builder
    public UsuarioJpa(String name, Long phoneNumber, String email, List<String> addresses, List<Long> cards,
            String password, List<Pedido> pedido) {
        super(name, phoneNumber);
        this.email = email;
        this.addresses = addresses;
        this.cards = cards;
        this.password = password;
        this.pedido = pedido;
    }

    
}