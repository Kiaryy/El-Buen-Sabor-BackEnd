package com.example.demo.service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.ArticleJpa;
import com.example.demo.models.PlateIngredient;
import com.example.demo.models.PlatoJpa;
import com.example.demo.models.enums.Tipo;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.PlatoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlateInitializerService {
    private final PlatoJpaRepository repository;
    @Autowired
    public PlateInitializerService(PlatoJpaRepository repository) {
        this.repository = repository;
    }
    @Autowired
    private ArticleRepository articleRepository;

    public String deleteMenu(){

        List<PlatoJpa> all = repository.findAll();

        repository.deleteAll(all);

        return "All entries from plates table deleted." ;

    }

    public List<PlatoJpa> loadMenu(){
        List<ArticleJpa> ingredients = articleRepository.findAll();

        List<PlatoJpa> plates = new ArrayList<>();

        //      ------------Empanadas------------
        try {
                plates.add(PlatoJpa.builder()
                        .name("Empanada de Carne")
                        .description("Empanada rellena con carne picada sazonada, cebolla, pimiento rojo y especias, todo cocido a la perfección.  Se vende por docena.")
                        .type(Tipo.EMPANADA)
                        .price(4000D)
                        .stock(25)
                        .available(true)
                        // Convierte el archivo en un array de bytes y lo guarda en db
                        .imageData(Files.readAllBytes(new File("MENU\\empandas-carne.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        // Añade 1 unidad del ingrediente con id 15 al ultimo plato
                        PlateIngredient.builder().ingredient(ingredients.get(29)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(37)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(3)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(4)).quantity(2).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Empanada de Jamon y Queso")
                        .description("Empanada rellena con una mezcla suave de jamón cocido y queso derretido, envuelta en una masa dorada y crujiente. El jamón y el queso se funden juntos, creando un interior jugoso y sabroso, perfecto como aperitivo o bocadillo. Se vende por docena.")
                        .type(Tipo.EMPANADA)
                        .price(3800D)
                        .stock(25)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\empanada-jyq.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(29)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(35)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(40)).quantity(2).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Empanada de Choclo")
                        .description("Empanada rellena con una mezcla de granos de choclo dulce, cebolla, queso y especias, envuelta en una masa dorada y crujiente. El relleno cremoso y ligeramente dulce del choclo ofrece una combinación deliciosa y reconfortante, ideal como aperitivo o plato ligero. Se vende por docena.")
                        .type(Tipo.EMPANADA)
                        .price(3700D)
                        .stock(25)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\empanada-choclo.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(29)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(5)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(3)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(40)).quantity(2).build()
                ));

                //      ------------Pizzas------------
                plates.add(PlatoJpa.builder()
                        .name("Pizza Muzzarella")
                        .description("Pizza tradicional, cubierta con una capa generosa de salsa de tomate casera y queso muzzarella derretido.")
                        .type(Tipo.PIZZA)
                        .price(2800D)
                        .stock(20)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\pizza-muzarella.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(31)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(1)).quantity(4).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(40)).quantity(2).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Pizza Pollo y Espinaca")
                        .description("Pizza con una base crujiente y dorada, cubierta con una capa de salsa blanca suave, trozos de pollo a la parrilla, hojas de espinaca frescas y queso muzzarella derretido.")
                        .type(Tipo.PIZZA)
                        .price(3200D)
                        .stock(20)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\pizza-pollo-espinaca.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(31)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(10)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(34)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(11)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(40)).quantity(2).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Pizza Especial")
                        .description("Pizza cubierta con una capa de salsa de tomate, abundante queso muzzarella derretido y una combinación clásica de jamón cocido, rodajas de morrón rojo asado y aceitunas verdes.")
                        .type(Tipo.PIZZA)
                        .price(3100D)
                        .stock(20)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\pizza especial.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(31)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(1)).quantity(4).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(35)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(12)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(13)).quantity(4).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(40)).quantity(2).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Pizza Hawaiana")
                        .description("Pizza cubierta con salsa de tomate, una generosa capa de queso muzzarella derretido, rodajas de jamón cocido y trozos de ananá jugoso.")
                        .type(Tipo.PIZZA)
                        .price(3000D)
                        .stock(20)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\pizza-hawaiana.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(31)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(1)).quantity(4).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(35)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(24)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(40)).quantity(2).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Pizza Champiñones (vegetariana)")
                        .description("Pizza con una base crujiente y esponjosa, cubierta con salsa de tomate y una generosa cantidad de queso muzzarella derretido, adornada con champiñones frescos salteados en aceite de oliva y ajo.")
                        .type(Tipo.PIZZA)
                        .price(2900D)
                        .stock(20)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\pizza-champiñones.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(31)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(1)).quantity(4).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(27)).quantity(3).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(15)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(14)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(40)).quantity(2).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Pizza Vegetales Asados (vegana)")
                        .description("Pizza con una base crujiente y dorada, cubierta con salsa de tomate y queso muzzarella derretido, acompañada de una mezcla de vegetales frescos como pimientos, cebolla, champiñones y tomates en rodajas.")
                        .type(Tipo.PIZZA)
                        .price(3000D)
                        .stock(20)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\pizza-vegetales.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(31)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(1)).quantity(6).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(4)).quantity(3).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(3)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(27)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(40)).quantity(2).build()
                ));

                //      ------------Hamburguesas------------
                plates.add(PlatoJpa.builder()
                        .name("Hamburguesa Clásica de la Casa")
                        .description("Una hamburguesa clásica con una carne super jugosa y un sabor incomparable. Carne jugosa, queso cheddar derretido, tomate, lechuga y pepino.")
                        .type(Tipo.HAMBURGUESA)
                        .price(2800D)
                        .stock(20)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\burger-clasica.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(28)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(44)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(1)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(0)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(6)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(33)).quantity(1).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Hamburguesa Bacon y Huevo")
                        .description("Un jugoso medallón de carne a la parrilla, acompañada de crujientes tiras de bacon y un huevo frito con la yema ligeramente líquida. ")
                        .type(Tipo.HAMBURGUESA)
                        .price(3000D)
                        .stock(20)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\burger-bacon-egg.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(28)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(36)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(45)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(33)).quantity(1).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Hamburguesa Cebolla y Bacon")
                        .description("Medallón de carne a la parrilla, cubierta con cebolla caramelizada que aporta un toque dulce y tiras crujientes de bacon.")
                        .type(Tipo.HAMBURGUESA)
                        .price(2900D)
                        .stock(20)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\burger-bbq.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(28)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(3)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(36)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(33)).quantity(1).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Hamburguesa Pollo Crispy Simple")
                        .description("Pechuga de pollo empanada y frita hasta quedar crujiente por fuera y jugosa por dentro.")
                        .type(Tipo.HAMBURGUESA)
                        .price(2600D)
                        .stock(20)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\burger-crispy-chicken.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(28)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(32)).quantity(1).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Hamburguesa Pollo, Bacon y Cebolla Crispy")
                        .description("Pechuga de pollo empanada y frita hasta quedar extra crujiente, cubierta con tiras de bacon crocante, cebolla crispy dorada y dos generosas capas de queso cheddar derretido.")
                        .type(Tipo.HAMBURGUESA)
                        .price(3100D)
                        .stock(20)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\burger-chicken-bacon.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(28)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(36)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(3)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(44)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(32)).quantity(1).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Hamburguesa Vegana Simple")
                        .description("Hamburguesa vegana con un medallón a base de legumbres, aderezado con hierbas y especias. Acompañada de tomate y lechuga.")
                        .type(Tipo.HAMBURGUESA)
                        .price(2700D)
                        .stock(20)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\burger-vegan.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(28)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(1)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(0)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(7)).quantity(1).build()
                ));

                //      ------------Acompañamientos------------
                plates.add(PlatoJpa.builder()
                        .name("Papas Fritas Caseras")
                        .description("Papas fritas doradas y crujientes, sazonadas con sal gruesa y una pizca de especias.")
                        .type(Tipo.ACOMPAÑANMIENTO)
                        .price(1800D)
                        .stock(30)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\acompañamineto-papas-fritas.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(8)).quantity(1).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Aros de Cebolla")
                        .description("Aros de cebolla frescos, rebozados y fritos hasta obtener un exterior crujiente y dorado, con un interior suave y dulce.")
                        .type(Tipo.ACOMPAÑANMIENTO)
                        .price(1600D)
                        .stock(30)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\acompañamiento-onion-rings.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(3)).quantity(1).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Papas con Cheddar y Bacon Triturado")
                        .description("Papas fritas doradas y crujientes, cubiertas con una capa de queso cheddar fundido y bacon triturado.")
                        .type(Tipo.ACOMPAÑANMIENTO)
                        .price(2000D)
                        .stock(30)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\acompañamiento-papas-cheddar-bacon.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(8)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(36)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(44)).quantity(1).build()
                ));
                //      ------------Postres------------
                plates.add(PlatoJpa.builder()
                        .name("Flan")
                        .description("Postre tradicional de suave y cremosa textura, hecho a base de huevos, leche y azúcar, con un delicado caramelo.")
                        .type(Tipo.POSTRE)
                        .price(1250D)
                        .stock(20)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\postre-flan.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(45)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(38)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(16)).quantity(1).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Alfajores de Maicena")
                        .description("Dulce de leche entre suaves galletas de maicena, cubierto con coco rallado.")
                        .type(Tipo.POSTRE)
                        .price(1000D)
                        .stock(25)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\postre-alfajores.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(19)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(20)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(21)).quantity(2).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Arroz Con Leche")
                        .description("Arroz cocido en leche con azúcar, canela y un toque de vainilla.")
                        .type(Tipo.POSTRE)
                        .price(1500D)
                        .stock(20)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\postre-arroz-con-leche.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(23)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(38)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(17)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(18)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(16)).quantity(2).build()
                ));

                //      ------------Ensaladas------------
                plates.add(PlatoJpa.builder()
                        .name("Ensalada César con Pollo")
                        .description("Clásica ensalada César con lechuga romana fresca, trozos de pollo a la parrilla, queso parmesano rallado y aderezo César cremoso.")
                        .type(Tipo.ENSALADA)
                        .price(2500D)
                        .stock(15)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\Ensalada-cesar-con-pollo.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(0)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(42)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(43)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(34)).quantity(1).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Ensalada Latina")
                        .description("Colorida ensalada con una mezcla de lechugas frescas, palta, tomate, choclo y frijoles negros. ")
                        .type(Tipo.ENSALADA)
                        .price(2400D)
                        .stock(15)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\Ensalada-latina.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(0)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(1)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(46)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(5)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(22)).quantity(2).build()
                ));

                plates.add(PlatoJpa.builder()
                        .name("Ensalada de Manzana, Queso Azul y Nuez")
                        .description("Mezcla de hojas verdes frescas con rodajas de manzana, queso azul desmenuzado y nueces crujientes. ")
                        .type(Tipo.ENSALADA)
                        .price(2600D)
                        .stock(15)
                        .available(true)
                        .imageData(Files.readAllBytes(new File("MENU\\ensalada manzana.png").toPath()))
                        .timesPurchased(0)
                        .build());

                plates.get(plates.size() -1).setIngredients(List.of(
                        PlateIngredient.builder().ingredient(ingredients.get(0)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(26)).quantity(2).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(41)).quantity(1).build(),
                        PlateIngredient.builder().ingredient(ingredients.get(25)).quantity(2).build()
                ));
        } catch (IOException e) {
                System.out.println(e.getMessage());
        }


        return repository.saveAll(plates);
    }




}
