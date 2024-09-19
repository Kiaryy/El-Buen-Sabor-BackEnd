package com.example.demo.DTO.request;
public record UsuarioRequestDTO(
        String name,
        String mail,
        String address,
        String passWord
) {
}
