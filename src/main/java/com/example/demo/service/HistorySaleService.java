package com.example.demo.service;

import com.example.demo.DTO.request.HistorySaleRequestDTO;
import com.example.demo.models.HistorySale;
import com.example.demo.repository.HistorySaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HistorySaleService {

    @Autowired
    private HistorySaleRepository historySaleRepository;

    public List<HistorySale> getAllHistorySales() {return historySaleRepository.findAll();}

    public String addHistorySale(HistorySaleRequestDTO historySaleDTO) {
        HistorySale historySale = HistorySale.builder()
                .userId(historySaleDTO.userId())
                .card(historySaleDTO.card())
                .dateSale(LocalDate.now())
                .pedido(historySaleDTO.pedido())
                .build();
        historySaleRepository.save(historySale);
        return "History Sale added";
    }

    public boolean delete(Long id) {
        if (historySaleRepository.existsById(id)) {
            historySaleRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
