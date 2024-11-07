package com.example.demo.service;

import com.example.demo.DTO.request.PlatoRequestDTO;
import com.example.demo.DTO.request.UsuarioPedidoRequest;
import com.example.demo.models.Pedido;
import com.example.demo.models.UsuarioJpa;
import com.example.demo.repository.UsuarioJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

@Service
@AllArgsConstructor
@Log4j2
public class PedidoService {
    private UsuarioJpaRepository usuarioJpaRepository;
    public String realizarPedido(UsuarioPedidoRequest request) {
        log.info(request);
        Optional<UsuarioJpa> userOpt =  usuarioJpaRepository.findById(request.getUserId());

        if(userOpt.isEmpty()){
            throw new RuntimeException("El usuario no existe");
        }

        UsuarioJpa user = userOpt.get();
        Pedido pedido = Pedido.builder()
                .nombreDelivery(request.getDeliveryName())
                .productos(request.getProductos())
                .user(user.getName())
                .build();

        user.getPedido().add(pedido);

        log.info("Pedido: ",pedido);
        log.info("User: ",user);

        usuarioJpaRepository.save(user);

        return "Pedido realizado con exito";
    }
    public static String listToString(List<PlatoRequestDTO> list, String delimiter) {
        StringJoiner joiner = new StringJoiner(delimiter);
        for (PlatoRequestDTO item : list) {
            joiner.add(item.name());
            joiner.add("Description:");
            joiner.add(item.type().toString());
        }
        return joiner.toString();
    }
}

