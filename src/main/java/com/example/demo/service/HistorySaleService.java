package com.example.demo.service;

import com.example.demo.DTO.request.HistorySaleRequestDTO;
import com.example.demo.models.HistorySale;
import com.example.demo.repository.HistorySaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HistorySaleService {

    @Autowired
    private HistorySaleRepository historySaleRepository;

    public List<HistorySale> getAllHistorySales() {return historySaleRepository.findAll();}

    public String addHistorySale(HistorySaleRequestDTO historySaleDTO) {
        HistorySale historySale = HistorySale.builder()
                .nameofUser(historySaleDTO.nameofUser())
                .cards(historySaleDTO.cards())
                .dateSale(LocalDate.now())
                .pedido(historySaleDTO.pedido())
                .build();
        historySaleRepository.save(historySale);
        return "History Sale added";
    }

    public HistorySale update(Long id, HistorySaleRequestDTO entity) {
        Optional<HistorySale> entityOptional = historySaleRepository.findById(id);
        HistorySale historySale = entityOptional.get();
        historySale.setNameofUser(entity.nameofUser());
        historySale.setCards(entity.cards());
        historySale.setDateSale(LocalDate.now());
        historySale.setPedido(entity.pedido());
        return historySaleRepository.save(historySale);
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
