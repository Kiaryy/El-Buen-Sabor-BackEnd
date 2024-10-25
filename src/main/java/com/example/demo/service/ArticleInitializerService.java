package com.example.demo.service;

import com.example.demo.models.ArticleJpa;
import com.example.demo.models.enums.ArticleCategory;
import com.example.demo.models.enums.Providers;
import com.example.demo.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleInitializerService {

    private final ArticleRepository repository;

    public ArticleInitializerService(ArticleRepository repository) {
        this.repository = repository;
    }

    public String deleteArticle() {
        List <ArticleJpa> all= repository.findAll();
        repository.deleteAll(all);
        return "All articles deleted";
    }

    public List<ArticleJpa> loadArticles() {
        List <ArticleJpa> articles = new ArrayList<>();

        //           --------------------- Vegetales ---------------------//
        articles.add(ArticleJpa.builder()
                .name("Lechuga")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(200.0)
                .precioCompra(400.0)
                .stockActual(500)
                .existencies(250)
                .lastPurchased(LocalDate.of(2004, 9, 29))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Tomate")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(150.0)
                .precioCompra(350.0)
                .stockActual(600)
                .existencies(300)
                .lastPurchased(LocalDate.of(2024, 10, 1))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Zanahoria")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(180.0)
                .precioCompra(320.0)
                .stockActual(550)
                .existencies(275)
                .lastPurchased(LocalDate.of(2024, 9, 30))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Cebolla")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(150.0)
                .precioCompra(300.0)
                .stockActual(432)
                .existencies(155)
                .lastPurchased(LocalDate.of(2024, 9, 30))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Pimiento Rojo")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(100.0)
                .precioCompra(210.0)
                .stockActual(530)
                .existencies(260)
                .lastPurchased(LocalDate.of(2024, 3, 10))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Choclo")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(240.5)
                .precioCompra(540.5)
                .stockActual(210)
                .existencies(100)
                .lastPurchased(LocalDate.of(2024, 6, 15))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Pepino")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(200.0)
                .precioCompra(350.0)
                .stockActual(500)
                .existencies(320)
                .lastPurchased(LocalDate.of(2024, 4, 12))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Medallon de hamburguesa Vegetariana")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(400.0)
                .precioCompra(650.0)
                .stockActual(200)
                .existencies(120)
                .lastPurchased(LocalDate.of(2024, 3, 20))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Papas")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(300.0)
                .precioCompra(420.0)
                .stockActual(700)
                .existencies(540)
                .lastPurchased(LocalDate.of(2024, 5, 31))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Aguacate")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(400.0)
                .precioCompra(650.0)
                .stockActual(320)
                .existencies(110)
                .lastPurchased(LocalDate.of(2024, 4, 12))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Salsa Blanca")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(400.0)
                .precioCompra(650.0)
                .stockActual(320)
                .existencies(110)
                .lastPurchased(LocalDate.of(2024, 4, 12))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Espinaca")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(400.0)
                .precioCompra(650.0)
                .stockActual(320)
                .existencies(110)
                .lastPurchased(LocalDate.of(2024, 4, 12))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Morron Rojo")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(400.0)
                .precioCompra(650.0)
                .stockActual(320)
                .existencies(110)
                .lastPurchased(LocalDate.of(2024, 4, 12))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Aceitunas")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(400.0)
                .precioCompra(650.0)
                .stockActual(320)
                .existencies(110)
                .lastPurchased(LocalDate.of(2024, 4, 12))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Ajo")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(400.0)
                .precioCompra(650.0)
                .stockActual(320)
                .existencies(110)
                .lastPurchased(LocalDate.of(2024, 4, 12))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Aceite de Oliva")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(400.0)
                .precioCompra(650.0)
                .stockActual(320)
                .existencies(110)
                .lastPurchased(LocalDate.of(2024, 4, 12))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Azucar")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(400.0)
                .precioCompra(650.0)
                .stockActual(320)
                .existencies(110)
                .lastPurchased(LocalDate.of(2024, 4, 12))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Canela")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(400.0)
                .precioCompra(650.0)
                .stockActual(320)
                .existencies(110)
                .lastPurchased(LocalDate.of(2024, 4, 12))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Vainilla")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(400.0)
                .precioCompra(650.0)
                .stockActual(320)
                .existencies(110)
                .lastPurchased(LocalDate.of(2024, 4, 12))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Dulce de Leche")
                .category(ArticleCategory.DAIRY)
                .provider(Providers.YAGUAR)
                .priceUnit(400.0)
                .precioCompra(650.0)
                .stockActual(320)
                .existencies(110)
                .lastPurchased(LocalDate.of(2024, 4, 12))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Maicena")
                .category(ArticleCategory.DAIRY)
                .provider(Providers.YAGUAR)
                .priceUnit(400.0)
                .precioCompra(650.0)
                .stockActual(320)
                .existencies(110)
                .lastPurchased(LocalDate.of(2024, 4, 12))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Coco Rallado")
                .category(ArticleCategory.FRUITS)
                .provider(Providers.YAGUAR)
                .priceUnit(400.0)
                .precioCompra(650.0)
                .stockActual(320)
                .existencies(110)
                .lastPurchased(LocalDate.of(2024, 4, 12))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Salsa Blanca")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(420.0)
                .precioCompra(670.0)
                .stockActual(310)
                .existencies(115)
                .lastPurchased(LocalDate.of(2024, 9, 18))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Espinaca")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(410.0)
                .precioCompra(665.0)
                .stockActual(330)
                .existencies(120)
                .lastPurchased(LocalDate.of(2024, 9, 16))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Morron Rojo")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(395.0)
                .precioCompra(660.0)
                .stockActual(300)
                .existencies(105)
                .lastPurchased(LocalDate.of(2024, 9, 10))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Aceitunas")
                .category(ArticleCategory.FRUITS)
                .provider(Providers.YAGUAR)
                .priceUnit(450.0)
                .precioCompra(680.0)
                .stockActual(315)
                .existencies(95)
                .lastPurchased(LocalDate.of(2024, 9, 5))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Ajo")
                .category(ArticleCategory.VEGETABLE)
                .provider(Providers.YAGUAR)
                .priceUnit(425.0)
                .precioCompra(675.0)
                .stockActual(340)
                .existencies(100)
                .lastPurchased(LocalDate.of(2024, 8, 20))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Aceite de Oliva")
                .category(ArticleCategory.DIP)
                .provider(Providers.KANSAS)
                .priceUnit(460.0)
                .precioCompra(690.0)
                .stockActual(350)
                .existencies(130)
                .lastPurchased(LocalDate.of(2024, 8, 15))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Azucar")
                .category(ArticleCategory.SUGAR)
                .provider(Providers.LEDESMA)
                .priceUnit(370.0)
                .precioCompra(640.0)
                .stockActual(280)
                .existencies(115)
                .lastPurchased(LocalDate.of(2024, 8, 12))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Canela")
                .category(ArticleCategory.SPICES)
                .provider(Providers.ABUANA)
                .priceUnit(390.0)
                .precioCompra(655.0)
                .stockActual(290)
                .existencies(120)
                .lastPurchased(LocalDate.of(2024, 7, 22))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Vainilla")
                .category(ArticleCategory.SPICES)
                .provider(Providers.ABUANA)
                .priceUnit(385.0)
                .precioCompra(645.0)
                .stockActual(285)
                .existencies(125)
                .lastPurchased(LocalDate.of(2024, 7, 18))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Dulce de Leche")
                .category(ArticleCategory.CARAMEL_SAUCE)
                .provider(Providers.SERENISIMA)
                .priceUnit(440.0)
                .precioCompra(700.0)
                .stockActual(330)
                .existencies(105)
                .lastPurchased(LocalDate.of(2024, 7, 10))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Maicena")
                .category(ArticleCategory.CEREALS)
                .provider(Providers.SAICA)
                .priceUnit(375.0)
                .precioCompra(660.0)
                .stockActual(315)
                .existencies(115)
                .lastPurchased(LocalDate.of(2024, 6, 25))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Coco Rallado")
                .category(ArticleCategory.FRUITS)
                .provider(Providers.YAGUAR)
                .priceUnit(430.0)
                .precioCompra(680.0)
                .stockActual(340)
                .existencies(110)
                .lastPurchased(LocalDate.of(2024, 6, 20))
                .build());


        //           --------------------- Legumbres ---------------------
        articles.add(ArticleJpa.builder()
                .name("Frijoles")
                .category(ArticleCategory.LEGUMES)
                .provider(Providers.YAGUAR)
                .priceUnit(140.0)
                .precioCompra(250.0)
                .stockActual(500)
                .existencies(270)
                .lastPurchased(LocalDate.of(2024, 7, 14))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Arroz")
                .category(ArticleCategory.CEREALS)
                .provider(Providers.LUCCHETTI)
                .priceUnit(155.0)
                .precioCompra(230.0)
                .stockActual(450)
                .existencies(250)
                .lastPurchased(LocalDate.of(2024, 10, 5))
                .build());

        //           --------------------- Frutas ---------------------
        articles.add(ArticleJpa.builder()
                .name("Anana")
                .category(ArticleCategory.FRUITS)
                .provider(Providers.YAGUAR)
                .priceUnit(140.0)
                .precioCompra(200.5)
                .stockActual(150)
                .existencies(77)
                .lastPurchased(LocalDate.of(2024, 2, 18))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Nuez")
                .category(ArticleCategory.FRUITS)
                .provider(Providers.YAGUAR)
                .priceUnit(250.0)
                .precioCompra(180.0)
                .stockActual(120)
                .existencies(65)
                .lastPurchased(LocalDate.of(2024, 9, 15))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Manzana")
                .category(ArticleCategory.FRUITS)
                .provider(Providers.YAGUAR)
                .priceUnit(180.0)
                .precioCompra(220.0)
                .stockActual(200)
                .existencies(85)
                .lastPurchased(LocalDate.of(2024, 10, 10))
                .build());

        //           --------------------- Hongos ---------------------
        articles.add(ArticleJpa.builder()
                .name("Champiñones")
                .category(ArticleCategory.FUNGUS)
                .provider(Providers.YAGUAR)
                .priceUnit(160.0)
                .precioCompra(230.0)
                .stockActual(120)
                .existencies(66)
                .lastPurchased(LocalDate.of(2024, 5, 21))
                .build());

        //           --------------------- Horneado ---------------------
        articles.add(ArticleJpa.builder()
                .name("Pan Integral")
                .category(ArticleCategory.BAKED)
                .provider(Providers.BIMBO)
                .priceUnit(250.0)
                .precioCompra(500.0)
                .stockActual(1000)
                .existencies(500)
                .lastPurchased(LocalDate.of(2024, 8, 20))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Harina de Trigo")
                .category(ArticleCategory.BAKED)
                .provider(Providers.PUREZA)
                .priceUnit(100.0)
                .precioCompra(250.0)
                .stockActual(800)
                .existencies(400)
                .lastPurchased(LocalDate.of(2024, 7, 10))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Pan Blanco")
                .category(ArticleCategory.BAKED)
                .provider(Providers.BIMBO)
                .priceUnit(220.0)
                .precioCompra(450.0)
                .stockActual(900)
                .existencies(450)
                .lastPurchased(LocalDate.of(2023, 8, 10))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Masa para Pizza")
                .category(ArticleCategory.BAKED)
                .provider(Providers.PUREZA)
                .priceUnit(300.0)
                .precioCompra(600.0)
                .stockActual(700)
                .existencies(350)
                .lastPurchased(LocalDate.of(2024, 7, 5))
                .build());

        //           --------------------- Carnes ---------------------
        articles.add(ArticleJpa.builder()
                .name("Hamburguesa de Pollo")
                .category(ArticleCategory.MEAT)
                .provider(Providers.PATTY)
                .priceUnit(700.0)
                .precioCompra(1400.0)
                .stockActual(450)
                .existencies(225)
                .lastPurchased(LocalDate.of(2024, 9, 15))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Hamburguesa de Res")
                .category(ArticleCategory.MEAT)
                .provider(Providers.PATTY)
                .priceUnit(280.0)
                .precioCompra(520.5)
                .stockActual(400)
                .existencies(200)
                .lastPurchased(LocalDate.of(2024, 9, 17))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Pollos")
                .category(ArticleCategory.MEAT)
                .provider(Providers.PATTY)
                .priceUnit(150.0)
                .precioCompra(300.0)
                .stockActual(300)
                .existencies(155)
                .lastPurchased(LocalDate.of(2024, 5, 21))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Jamon Cocido")
                .category(ArticleCategory.MEAT)
                .provider(Providers.PATTY)
                .priceUnit(300.0)
                .precioCompra(400.0)
                .stockActual(432)
                .existencies(155)
                .lastPurchased(LocalDate.of(2024, 9, 30))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Bacon")
                .category(ArticleCategory.MEAT)
                .provider(Providers.PATTY)
                .priceUnit(230.0)
                .precioCompra(500.0)
                .stockActual(400)
                .existencies(320)
                .lastPurchased(LocalDate.of(2024, 9, 25))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Carne de Res")
                .category(ArticleCategory.MEAT)
                .provider(Providers.PATTY)
                .priceUnit(270.0)
                .precioCompra(550.0)
                .stockActual(300)
                .existencies(220)
                .lastPurchased(LocalDate.of(2024, 10, 10))
                .build());

        //           --------------------- Lacteos ---------------------
        articles.add(ArticleJpa.builder()
                .name("Leche Entera")
                .category(ArticleCategory.DAIRY)
                .provider(Providers.SERENISIMA)
                .priceUnit(120.0)
                .precioCompra(300.0)
                .stockActual(1200)
                .existencies(600)
                .lastPurchased(LocalDate.of(2024, 9, 22))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Yogur Natural")
                .category(ArticleCategory.DAIRY)
                .provider(Providers.SERENISIMA)
                .priceUnit(130.0)
                .precioCompra(270.0)
                .stockActual(1100)
                .existencies(550)
                .lastPurchased(LocalDate.of(2024, 9, 25))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Queso Muzzarella")
                .category(ArticleCategory.DAIRY)
                .provider(Providers.ELABASTO)
                .priceUnit(130.0)
                .precioCompra(270.0)
                .stockActual(1100)
                .existencies(550)
                .lastPurchased(LocalDate.of(2024, 9, 25))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Queso Azul")
                .category(ArticleCategory.DAIRY)
                .provider(Providers.ELABASTO)
                .priceUnit(130.0)
                .precioCompra(270.0)
                .stockActual(1100)
                .existencies(550)
                .lastPurchased(LocalDate.of(2024, 2, 9))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Queso Parmesano")
                .category(ArticleCategory.DAIRY)
                .provider(Providers.ELABASTO)
                .priceUnit(130.0)
                .precioCompra(270.0)
                .stockActual(1100)
                .existencies(550)
                .lastPurchased(LocalDate.of(2024, 5, 12))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Aderezo Cesar")
                .category(ArticleCategory.DRESSINGS)
                .provider(Providers.KANSAS)
                .priceUnit(130.0)
                .precioCompra(270.0)
                .stockActual(1100)
                .existencies(550)
                .lastPurchased(LocalDate.of(2024, 6, 21))
                .build());

        articles.add(ArticleJpa.builder()
                .name("Queso Cheddar")
                .category(ArticleCategory.DAIRY)
                .provider(Providers.ELABASTO)
                .priceUnit(200.0)
                .precioCompra(350.0)
                .stockActual(500)
                .existencies(320)
                .lastPurchased(LocalDate.of(2024, 4, 12))
                .build());

        //           --------------------- Huevos ---------------------
        articles.add(ArticleJpa.builder()
                .name("Huevos")
                .category(ArticleCategory.DAIRY)
                .provider(Providers.ELABASTO)
                .priceUnit(200.0)
                .precioCompra(350.0)
                .stockActual(500)
                .existencies(320)
                .lastPurchased(LocalDate.of(2024, 2, 19))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Palta")
                .category(ArticleCategory.FRUITS)
                .provider(Providers.YAGUAR)
                .priceUnit(140.0)
                .precioCompra(200.5)
                .stockActual(150)
                .existencies(77)
                .lastPurchased(LocalDate.of(2024, 7, 18))
                .build());
        
        articles.add(ArticleJpa.builder()
                .name("Palta")
                .category(ArticleCategory.FRUITS)
                .provider(Providers.YAGUAR)
                .priceUnit(140.0)
                .precioCompra(200.5)
                .stockActual(150)
                .existencies(77)
                .lastPurchased(LocalDate.of(2024, 2, 18))
                .build());

        return repository.saveAll(articles);
    }
}
