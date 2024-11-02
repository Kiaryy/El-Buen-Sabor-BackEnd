package com.example.demo.controller;
import com.example.demo.DTO.request.BinancePayRequest;
import com.example.demo.DTO.request.QuoteInquiryDTO;
import com.example.demo.service.BinanceService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping( "/binance")
@CrossOrigin(origins = "*")
@Log4j2
public class BinanceApiController {

    private final BinanceService binanceService;

    @PostMapping("/convert")
    public ResponseEntity<String> convert(@RequestBody QuoteInquiryDTO quoteInquiry) {
        String result = binanceService.convert(quoteInquiry);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/exchangeInfo")
    public ResponseEntity<String> getExchangeInfo() {
        String result = binanceService.getExchangeInfo();
        return ResponseEntity.ok(result);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createPayment(@RequestBody BinancePayRequest binancePayRequest) {
        try {
            String response = binanceService.createOrder(binancePayRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

}
