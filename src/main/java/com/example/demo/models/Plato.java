package com.example.demo.models;

import com.example.demo.models.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//With Lombok
@Getter
@Setter
@AllArgsConstructor
public class Plato {
    private String name;
    private String description;
    private Tipo type;
    private Double price;
    private int stock;
    private boolean avaliable;
    private String img; 


}
