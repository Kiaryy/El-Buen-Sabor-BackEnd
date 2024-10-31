package com.example.demo.controller;

import com.example.demo.DTO.request.userPreferenceRequest;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;


import com.example.demo.DTO.request.UsuarioPedidoRequest;
import com.example.demo.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.log4j.Log4j2;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pedido")
@AllArgsConstructor
@CrossOrigin(origins = "*")
@Log4j2
public class PedidoController {

    private PedidoService pedidoService;
    @PostMapping("/realizarPedido")
    public ResponseEntity<String> realizarPedido(@RequestBody UsuarioPedidoRequest pedidoRequest ){
        return ResponseEntity.ok(pedidoService.realizarPedido(pedidoRequest));
    }

    @PostMapping("/createPreference")
    public Preference createPreference(@RequestBody List<userPreferenceRequest> userItemsPreference ) {
        MercadoPagoConfig.setAccessToken("APP_USR-3152703235404722-102218-53fe358050253c60902835a04a1b5a2a-2045302897");

        List<PreferenceItemRequest> items = new ArrayList<>();

        userItemsPreference.forEach(userPreference -> {
            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                    .id("1234") //require
                    .title(userPreference.title()) //require
                    .pictureUrl("http://picture.com/PS5")
                    .categoryId("games")
                    .quantity(userPreference.quantity()) //require
                    .unitPrice(new BigDecimal(userPreference.price())) //require
                    .build();
            items.add(itemRequest);
        });

        // Preference Back url
        PreferenceBackUrlsRequest backUrl = PreferenceBackUrlsRequest.builder()
                .success("http://localhost:8080/home")
                .build();

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .backUrls(backUrl)        
                .items(items).build();        

        PreferenceClient client = new PreferenceClient();
        Preference preference;
        try {
            preference = client.create(preferenceRequest);
            
        } catch (MPException e) {
            throw new RuntimeException(e);
        } catch (MPApiException e) {
            throw new RuntimeException(e);
        }
        log.info(preference);
        return preference;
    }

}
