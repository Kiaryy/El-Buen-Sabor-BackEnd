package com.example.demo.controller;

import com.binance.connector.client.exceptions.BinanceClientException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import com.binance.connector.client.SpotClient;
import com.binance.connector.client.impl.SpotClientImpl;
import org.springframework.web.server.ResponseStatusException;

@RestController
@AllArgsConstructor
@RequestMapping( "/binance")
@CrossOrigin(origins = "*")
@Log4j2
public class BinanceApiController {

    private static final double amount = 0.001;

    @PostMapping("/convert")
        public String QuoteInquiry(@RequestBody QuoteInquiryDTO quoteInquiry) {


            log.debug("From Asset", quoteInquiry.fromAsset());
            log.debug("To Asset", quoteInquiry.toAsset());
            Map<String, Object> params = new HashMap<>();
            params.put("fromAsset", quoteInquiry.fromAsset());
            params.put("toAsset", quoteInquiry.toAsset());
            params.put("fromAmount",quoteInquiry.fromAmount());
            SpotClient client = new SpotClientImpl("UJngDZcj7MhcRTJhOmrLBCUSzomVo6yK8uz2UkGwzQxE56oDtKtgt1yvaTRFTYgp","SSWqPrrwiFay70pVlG8XSlGH0UBbHEGzu1o6Gj3oZmMRLN18EDeQz482S8kUl140");
           try {
               String result = client.createConvert().quoteInquiry(params);
               System.out.println(result);
           }catch (BinanceClientException e) {
               log.error("Error al ejecutar la solicitud: {}", e.getMessage());
               throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No autorizado para ejecutar esta solicitud", e);
           }
            return "Quote Inquiry";
        }
    public record QuoteInquiryDTO (
            String fromAsset,
            String toAsset,
            double fromAmount
    ) {}

}
