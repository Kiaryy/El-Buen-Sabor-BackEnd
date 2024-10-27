package com.example.demo.models;

import com.example.demo.models.enums.Tipo;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//With Lombok
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlatoJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long platoId;

    @Column(columnDefinition = "varchar(100)")
    private String name;
    @Column(columnDefinition = "varchar(600)")
    private String description;
    private Tipo type;
    private Double price;
    private int stock;
    private boolean available;
    
    @Lob
    @Column(name = "image_data", columnDefinition="MEDIUMBLOB")
    private byte[] imageData;
    private int timesPurchased;
    
    @ElementCollection
    private List<ArticleReference> articles = new ArrayList<>();
    
    public boolean getAvaliable(){
        return this.available;
    }
}
