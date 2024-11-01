package com.example.demo.service;

import com.binance.connector.client.impl.SpotClientImpl;
import com.example.demo.DTO.request.BinancePayRequest;
import com.example.demo.DTO.request.QuoteInquiryDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Map;

@Service
@Log4j2
public class BinanceService {
    private final SpotClientImpl client;

    public BinanceService(@Value("${binance.api.key}") String apiKey,
                          @Value("${binance.secret.key}") String secretKey) {
        this.client = new SpotClientImpl(apiKey, secretKey,"https://testnet.binance.vision");
    }
    //Binance keys
    @Value("${binance.api.key}")
    private String binanceApiKey;
    @Value("${binance.secret.key}")
    private String binanceSecretKey;
    //PayBinance keys
    @Value("${binancePay.api.key}")
    private String BINANCE_PAY_KEY;
    @Value("${binancePay.secret.key}")
    private String BINANCE_PAY_SECRET_KEY;

    public String getExchangeInfo() {
        Map<String, Object> parameters = new LinkedHashMap<>();
        return client.createMarket().exchangeInfo(parameters);
    }

    public String convert(QuoteInquiryDTO quoteInquiry){
        Map<String, Object> params = new HashMap<>();
        params.put("fromAsset", quoteInquiry.fromAsset());
        params.put("toAsset", quoteInquiry.toAsset());

            String result = client.createConvert().exchangeInfo(params);
            System.out.println(result);

        return result;
    }

    public String createOrder(BinancePayRequest payRequest) throws Exception {
        String nonce = generateNonce();
        String timestamp = String.valueOf(System.currentTimeMillis());

        // Request creation
        Map<String, Object> body = new HashMap<>();
        Map<String, Object> env = new HashMap<>();
        env.put("terminalType", "APP");
        body.put("env", env);
        body.put("merchantTradeNo", payRequest.merchantTradeNo());
        body.put("orderAmount", payRequest.orderAmount());
        body.put("currency", payRequest.currency());

        Map<String, Object> goods = new HashMap<>();
        goods.put("goodsType", "01");
        goods.put("goodsCategory", "D000");
        goods.put("referenceGoodsId", "12345ABC");
        goods.put("goodsName", "El buen sabor");
        goods.put("goodsDetail", payRequest.message());

        body.put("goods", goods);

        String jsonBody = new ObjectMapper().writeValueAsString(body);
        log.info(jsonBody);
        // Create a payload with signature
        String payload = timestamp + "\n" + nonce + "\n" + jsonBody + "\n";
        String signature = generateSignature(payload);

        // Creations of headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("BinancePay-Timestamp", timestamp);
        headers.set("BinancePay-Nonce", nonce);
        headers.set("BinancePay-Certificate-SN", BINANCE_PAY_KEY);
        headers.set("BinancePay-Signature", signature);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);
        // Send request to Binancepay with credentials
        String url = "https://bpay.binanceapi.com/binancepay/openapi/v2/order";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    private String generateNonce() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder nonce = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int pos = (int) (Math.random() * chars.length());
            nonce.append(chars.charAt(pos));
        }
        return nonce.toString();
    }

    private String generateSignature(String payload) throws Exception {
        Mac sha256HMAC = Mac.getInstance("HmacSHA512");
        SecretKeySpec secretKeySpec = new SecretKeySpec(BINANCE_PAY_SECRET_KEY.getBytes(), "HmacSHA512");
        sha256HMAC.init(secretKeySpec);
        byte[] hash = sha256HMAC.doFinal(payload.getBytes());
        StringBuilder result = new StringBuilder();
        for (byte b : hash) {
            result.append(String.format("%02x", b));
        }
        return result.toString().toUpperCase();
    }

}