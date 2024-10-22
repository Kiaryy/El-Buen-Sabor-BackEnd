package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.PlatoJpa;
import com.example.demo.models.enums.Tipo;
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

    public String deleteMenu(){

        List<PlatoJpa> all = repository.findAll();

        repository.deleteAll(all);

        return "All entries from plates table deleted." ;

    }

    public List<PlatoJpa> loadMenu(){

        List<PlatoJpa> plates = new ArrayList<>();

        //      ------------Empanadas------------
        plates.add(PlatoJpa.builder()
                .name("Empanada de Carne")
                .description("Empanada rellena con carne picada sazonada, cebolla, pimiento rojo y especias, todo cocido a la perfección. " +
                        "La masa, dorada y crujiente, encierra el relleno jugoso y sabroso, ofreciendo una experiencia clásica y reconfortante en cada bocado. " +
                        "Ideal como aperitivo o plato principal. Se vende por docena.")
                .type(Tipo.EMPANADA)
                .price(4000D)
                .stock(25)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/empandas-carne.webp")
                .timesPurchased(0)

                .build());

        plates.add(PlatoJpa.builder()
                .name("Empanada de Jamon y Queso")
                .description("Empanada rellena con una mezcla suave de jamón cocido y queso derretido, envuelta en una masa dorada y crujiente. El jamón y el queso se funden juntos, creando un interior jugoso y sabroso, perfecto como aperitivo o bocadillo. Se vende por docena.")
                .type(Tipo.EMPANADA)
                .price(3800D)
                .stock(25)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/empanada-jyq.png")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Empanada de Choclo")
                .description("Empanada rellena con una mezcla de granos de choclo dulce, cebolla, queso y especias, envuelta en una masa dorada y crujiente. El relleno cremoso y ligeramente dulce del choclo ofrece una combinación deliciosa y reconfortante, ideal como aperitivo o plato ligero. Se vende por docena.")
                .type(Tipo.EMPANADA)
                .price(3700D)
                .stock(25)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/empanada-choclo.png")
                .timesPurchased(0)
                .build());

//      ------------Pizzas------------
        plates.add(PlatoJpa.builder()
                .name("Pizza Muzzarella")
                .description("Pizza tradicional con una base de masa esponjosa y ligeramente crujiente, cubierta con una capa generosa de salsa de tomate casera y abundante queso muzzarella derretido. Coronada con un toque de orégano y, opcionalmente, unas aceitunas verdes, es la clásica favorita por su sencillez y sabor reconfortante.")
                .type(Tipo.PIZZA)
                .price(2800D)
                .stock(20)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/pizza-muzarella.png")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Pizza Pollo y Espinaca")
                .description("Pizza con una base crujiente y dorada, cubierta con una capa de salsa blanca suave o de tomate, trozos de pollo a la parrilla, hojas de espinaca frescas y queso muzzarella derretido. Los sabores suaves del pollo y la espinaca se complementan perfectamente con el queso, creando una opción ligera y deliciosa.")
                .type(Tipo.PIZZA)
                .price(3200D)
                .stock(20)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/pizza-pollo-espinaca.jpg")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Pizza Especial")
                .description("Pizza con base de masa esponjosa, cubierta con una capa de salsa de tomate, abundante queso muzzarella derretido y una combinación clásica de jamón cocido, rodajas de morrón rojo asado y aceitunas verdes. Esta opción ofrece un equilibrio perfecto entre sabores suaves y ligeramente ahumados, ideal para quienes buscan algo más que lo tradicional.")
                .type(Tipo.PIZZA)
                .price(3100D)
                .stock(20)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/pizza especial.png")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Pizza Hawaiana")
                .description("Pizza con una base dorada y crujiente, cubierta con salsa de tomate, una generosa capa de queso muzzarella derretido, rodajas de jamón cocido y trozos de ananá jugoso. Esta combinación de sabores salados y dulces ofrece una experiencia única y refrescante, amada por quienes disfrutan de contrastes atrevidos en sus comidas.")
                .type(Tipo.PIZZA)
                .price(3000D)
                .stock(20)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/pizza-hawaiana.webp")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Pizza Champiñones (vegetariana)")
                .description("Pizza con una base crujiente y esponjosa, cubierta con salsa de tomate y una generosa cantidad de queso muzzarella derretido, adornada con champiñones frescos salteados en aceite de oliva y ajo. El sabor terroso y suave de los champiñones combina perfectamente con el queso, ofreciendo una opción simple pero deliciosa para los amantes de los ingredientes frescos.")
                .type(Tipo.PIZZA)
                .price(2900D)
                .stock(20)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/pizza-champiñones.webp")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Pizza Vegetales Asados (vegana)")
                .description("Pizza con una base crujiente y dorada, cubierta con salsa de tomate y queso muzzarella derretido, acompañada de una colorida mezcla de vegetales frescos como pimientos, cebolla, champiñones y tomates en rodajas. Los tomates aportan jugosidad y un sabor ligeramente dulce, equilibrando perfectamente con los otros vegetales y el queso, creando una opción deliciosa y nutritiva.")
                .type(Tipo.PIZZA)
                .price(3000D)
                .stock(20)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/pizza-vegetales.webp")
                .timesPurchased(0)
                .build());

//      ------------Hamburguesas------------
        plates.add(PlatoJpa.builder()
                .name("Hamburguesa Clásica de la Casa")
                .description("Una hamburguesa clásica con una carne super jugosa y un sabor incomparable. Contiene pan de papa, doble carne jugosa, queso cheddar derretido, tomate, lechuga, pepino y salsa de la casa.")
                .type(Tipo.HAMBURGUESA)
                .price(2800D)
                .stock(20)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/burger-clasica.webp")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Hamburguesa Bacon y Huevo")
                .description("Un jugoso medallón de carne a la parrilla, acompañada de crujientes tiras de bacon y un huevo frito con la yema ligeramente líquida. Todo servido en un pan suave con queso cheddar derretido, lechuga fresca y mayonesa, creando una deliciosa combinación de sabores clásicos y texturas.")
                .type(Tipo.HAMBURGUESA)
                .price(3000D)
                .stock(20)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/burger-bacon-egg.png")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Hamburguesa Cebolla y Bacon")
                .description("Medallón de carne a la parrilla, cubierta con cebolla caramelizada que aporta un toque dulce y tiras crujientes de bacon. Servida en un pan suave con queso cheddar derretido y una ligera capa de mayonesa, esta hamburguesa combina sabores intensos y texturas deliciosas.")
                .type(Tipo.HAMBURGUESA)
                .price(2900D)
                .stock(20)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/burger-bbq.webp")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Hamburguesa Pollo Crispy Simple")
                .description("Pechuga de pollo empanada y frita hasta quedar crujiente por fuera y jugosa por dentro. Servida en un pan suave, acompañada de rodajas de tomate fresco, lechuga crocante y una capa de mayonesa cremosa para equilibrar los sabores. Simple, pero deliciosa.")
                .type(Tipo.HAMBURGUESA)
                .price(2600D)
                .stock(20)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/burger-crispy-chicken.png")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Hamburguesa Pollo, Bacon y Cebolla Crispy")
                .description("Pechuga de pollo empanada y frita hasta quedar extra crujiente, cubierta con tiras de bacon crocante, cebolla crispy dorada y dos generosas capas de queso cheddar derretido. Servida en un pan suave con una capa de mayonesa para completar una experiencia jugosa y crujiente en cada mordida.")
                .type(Tipo.HAMBURGUESA)
                .price(3100D)
                .stock(20)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/burger-chicken-bacon.png")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Hamburguesa Vegana Simple")
                .description("Hamburguesa vegana con un medallón a base de legumbres, aderezado con hierbas y especias. Acompañada de tomate, lechuga y un toque de mayonesa vegana, esta opción es perfecta para quienes buscan una alternativa saludable y llena de sabor.")
                .type(Tipo.HAMBURGUESA)
                .price(2700D)
                .stock(20)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/burger-vegan.web.png")
                .timesPurchased(0)
                .build());

//      ------------Acompañamientos------------
        plates.add(PlatoJpa.builder()
                .name("Papas Fritas Caseras")
                .description("Papas fritas doradas y crujientes, sazonadas con sal gruesa y una pizca de especias. Perfectas para acompañar cualquier comida o disfrutar solas, ofreciendo un bocado reconfortante en cada ocasión.")
                .type(Tipo.ACOMPAÑANMIENTO)
                .price(1800D)
                .stock(30)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/papas-fritas.jpg")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Aros de Cebolla")
                .description("Aros de cebolla frescos, rebozados y fritos hasta obtener un exterior crujiente y dorado, con un interior suave y dulce. Ideales como aperitivo o para acompañar una hamburguesa, son un bocado clásico y delicioso.")
                .type(Tipo.ACOMPAÑANMIENTO)
                .price(1600D)
                .stock(30)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/aros-cebolla.webp")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Papas con Cheddar y Bacon Triturado")
                .description("Papas fritas doradas y crujientes, cubiertas con una capa de queso cheddar fundido y bacon triturado. Esta combinación irresistible ofrece el equilibrio perfecto entre la suavidad del queso, el crujiente de las papas y el sabor salado del bacon.")
                .type(Tipo.ACOMPAÑANMIENTO)
                .price(2000D)
                .stock(30)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/papas-cheddar-bacon.webp")
                .timesPurchased(0)
                .build());
//      ------------Postres------------
        plates.add(PlatoJpa.builder()
                .name("Flan")
                .description("Flan Casero")
                .type(Tipo.POSTRE)
                .price(1250D)
                .stock(20)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/postre-flan.webp")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Alfajores de Maicena")
                .description("Alfajores de Maicena")
                .type(Tipo.POSTRE)
                .price(1000D)
                .stock(25)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/postre-alfajores.webp")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Arroz Con Leche")
                .description("Arroz Con Leche")
                .type(Tipo.POSTRE)
                .price(1500D)
                .stock(20)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/postre-arroz-con-leche.webp")
                .timesPurchased(0)
                .build());

//      ------------Ensaladas------------
        plates.add(PlatoJpa.builder()
                .name("Ensalada César con Pollo")
                .description("Clásica ensalada César con lechuga romana fresca, crujientes croutons, trozos de pollo a la parrilla, queso parmesano rallado y aderezo César cremoso. Una opción ligera pero satisfactoria.")
                .type(Tipo.ENSALADA)
                .price(2500D)
                .stock(15)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/ensalada-cesar.webp")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Ensalada Latina")
                .description("Colorida ensalada con una mezcla de lechugas frescas, palta, tomate, choclo y frijoles negros. Aderezada con una vinagreta de lima y cilantro, esta opción ofrece una explosión de sabores vibrantes y frescos.")
                .type(Tipo.ENSALADA)
                .price(2400D)
                .stock(15)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/Ensalada-latina.webp")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Ensalada de Manzana, Queso Azul y Nuez")
                .description("Mezcla de hojas verdes frescas con rodajas de manzana, queso azul desmenuzado y nueces crujientes, todo aderezado con una vinagreta de miel y mostaza. Esta combinación de sabores dulces, salados y crujientes ofrece una opción gourmet y deliciosa.")
                .type(Tipo.ENSALADA)
                .price(2600D)
                .stock(15)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/ensalada-manzana-queso-nuez.jpg")
                .timesPurchased(0)
                .build());

//      ------------Bebidas------------
        plates.add(PlatoJpa.builder()
                .name("Coca-Cola 500ml")
                .description("Refresco Coca-Cola clásico en formato de 500 ml. Perfecto para acompañar cualquier comida o para refrescarse durante el día.")
                .type(Tipo.BEBIDA)
                .price(500D)
                .stock(50)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/bebeida-coca-medio.webp")
                .timesPurchased(0)
                .build());

        plates.add(PlatoJpa.builder()
                .name("Coca-Cola 1.5L")
                .description("Refresco Coca-Cola clásico en formato de 1.5 litros. Ideal para compartir en comidas familiares o reuniones.")
                .type(Tipo.BEBIDA)
                .price(800D)
                .stock(50)
                .available(true)
                .img("IMAGENES BUEN SABOR/MENU/bebeida-coca-medio.webp")
                .timesPurchased(0)
                .build());

        return repository.saveAll(plates);
    }




}
