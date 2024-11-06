package com.example.demo.controller;

import com.example.demo.models.ArticleJpa;
import com.example.demo.models.BebidasJpa;
import com.example.demo.models.PlatoJpa;
import com.example.demo.models.Providers;
import com.example.demo.models.UsuarioJpa;
import com.example.demo.service.ArticleInitializerService;
import com.example.demo.service.BebidasInitializer;
import com.example.demo.service.PlateInitializerService;
import com.example.demo.service.ProviderInitializer;
import com.example.demo.service.UserInitilizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/initializer/")
@CrossOrigin(origins = "*")

public class DataInitializerController {


    @Autowired
    PlateInitializerService platoService;
    
    @Autowired
    UserInitilizerService userService;
    
    @Autowired
    ArticleInitializerService articleService;
    
    @Autowired
    ProviderInitializer providersService;
    
    @Autowired
    BebidasInitializer bebidasService;
    @GetMapping("createPlates")
    public List<PlatoJpa> createAllPlates(){
        return platoService.loadMenu();
    }
    
    @GetMapping("createArticles")
    public List<ArticleJpa> createAllArticles(){
        return articleService.loadArticles();
    }
    
    @GetMapping("deleteAllArticles")
    public String deleteAllArticles(){
        return articleService.deleteArticle();
    }
    
    @GetMapping("deleteAllPlates")
    public String deleteAllPlates(){
        return platoService.deleteMenu();
    }
    
    @GetMapping("createUsers")
    public List<UsuarioJpa> createAllUsers(){
        return userService.createUsers();
    }
    
    @GetMapping("deleteAllUsers")
    public String deleteAllUsers(){
        return userService.deleteAllUsers();
    }
    @GetMapping("createProviders")
    public List<Providers> createAllProviders(){
        return providersService.loadProviders();
    }
    @GetMapping("createDrinks")
    public List<BebidasJpa> createAllDrinks(){
        return bebidasService.loadBebidas();
    }
    @GetMapping("deleteAllDrinks")
    public String deleteAllDrinks(){
        return bebidasService.deletedBebidas();
    }

}