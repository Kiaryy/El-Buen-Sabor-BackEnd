package com.example.demo.controller;

import com.example.demo.models.PlatoJpa;
import com.example.demo.service.PlatoInitializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("initializer/")
public class DataInitializerController {


    @Autowired
    PlatoInitializerService platoService;

    @GetMapping("createPlates")
    public List<PlatoJpa> findAll(){
        return platoService.loadMenu();
    }

    @GetMapping("deleteAllPlates")
    public String deleteAll(){
        return platoService.deleteMenu();
    }






}
