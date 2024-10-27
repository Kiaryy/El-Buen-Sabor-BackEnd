package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleReference {
    private Long articleId;
    private int quantity;
}
