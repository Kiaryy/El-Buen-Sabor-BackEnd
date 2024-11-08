package com.example.demo.DTO.request;

import lombok.Data;

import java.util.List;

import com.example.demo.models.DrinkReference;
import com.example.demo.models.PlateReference;

@Data
public class UsuarioPedidoRequest {
    private Long userId;
    private String deliveryName;
    private List<PlateReference> platos;
    private List<DrinkReference> bebidas;
}
