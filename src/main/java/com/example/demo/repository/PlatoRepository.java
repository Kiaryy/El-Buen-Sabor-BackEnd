package com.example.demo.repository;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.DTO.request.PlatoRequestDTO;
import com.example.demo.models.Plato;
import com.example.demo.models.enums.Tipo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class PlatoRepository {
    private List<Plato> platos = new ArrayList<Plato>();
    public List<Plato> findAll(){
        return platos;
    }
    @PostConstruct
    public void init(){
        //      ------------Empanadas------------
        platos.add(new Plato("Empanada de Carne"
            , "Empanada rellena con carne picada sazonada, cebolla, pimiento rojo y especias, todo cocido a la perfección. La masa, dorada y crujiente, encierra el relleno jugoso y sabroso, ofreciendo una experiencia clásica y reconfortante en cada bocado. Ideal como aperitivo o plato principal. Se vende por docena."
            , Tipo.EMPANADA
            , 2500D
            , 25
            , true
            , "IMAGENES BUEN SABOR/MENU/empandas-carne.webp"));
        platos.add(new Plato("Empanada de Jamon y Queso"
            , "Empanada rellena con una mezcla suave de jamón cocido y queso derretido, envuelta en una masa dorada y crujiente. El jamón y el queso se funden juntos, creando un interior jugoso y sabroso, perfecto como aperitivo o bocadillo. Se vende por docena."
            , Tipo.EMPANADA
            , 2500D
            , 25
            , true
            , "IMAGENES BUEN SABOR/MENU/empanada-jyq.png"));
        platos.add(new Plato("Empanada de Choclo"
            , "Empanada rellena con una mezcla de granos de choclo dulce, cebolla, queso y especias, envuelta en una masa dorada y crujiente. El relleno cremoso y ligeramente dulce del choclo ofrece una combinación deliciosa y reconfortante, ideal como aperitivo o plato ligero. Se vende por docena."
            , Tipo.EMPANADA
            , 2500D
            , 25
            , true
            , "IMAGENES BUEN SABOR/MENU/empanada-choclo.png"));

        //      ------------Pizzas------------
        platos.add(new Plato("Pizza Muzzarella"
            , "Pizza tradicional con una base de masa esponjosa y ligeramente crujiente, cubierta con una capa generosa de salsa de tomate casera y abundante queso muzzarella derretido. Coronada con un toque de orégano y, opcionalmente, unas aceitunas verdes, es la clásica favorita por su sencillez y sabor reconfortante."
            , Tipo.PIZZA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/pizza-muzarella.png"));
        platos.add(new Plato("Pizza Pollo y Espinaca"
            , "Pizza con una base crujiente y dorada, cubierta con una capa de salsa blanca suave o de tomate, trozos de pollo a la parrilla, hojas de espinaca frescas y queso muzzarella derretido. Los sabores suaves del pollo y la espinaca se complementan perfectamente con el queso, creando una opción ligera y deliciosa."
            , Tipo.PIZZA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/pizza-pollo-espinaca.jpg"));
        platos.add(new Plato("Pizza Especial"
            , "Pizza con base de masa esponjosa, cubierta con una capa de salsa de tomate, abundante queso muzzarella derretido y una combinación clásica de jamón cocido, rodajas de morrón rojo asado y aceitunas verdes. Esta opción ofrece un equilibrio perfecto entre sabores suaves y ligeramente ahumados, ideal para quienes buscan algo más que lo tradicional."
            , Tipo.PIZZA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/pizza especial.png"));
        platos.add(new Plato("Pizza Hawaiana"
            , "Pizza con una base dorada y crujiente, cubierta con salsa de tomate, una generosa capa de queso muzzarella derretido, rodajas de jamón cocido y trozos de ananá jugoso. Esta combinación de sabores salados y dulces ofrece una experiencia única y refrescante, amada por quienes disfrutan de contrastes atrevidos en sus comidas."
            , Tipo.PIZZA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/pizza-hawaiana.webp"));
        platos.add(new Plato("Pizza Champiñones (vegetariana)"
            , "Pizza con una base crujiente y esponjosa, cubierta con salsa de tomate y una generosa cantidad de queso muzzarella derretido, adornada con champiñones frescos salteados en aceite de oliva y ajo. El sabor terroso y suave de los champiñones combina perfectamente con el queso, ofreciendo una opción simple pero deliciosa para los amantes de los ingredientes frescos."
            , Tipo.PIZZA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/pizza-champiñones.webp"));
        platos.add(new Plato("Pizza Vegetales Asados (vegana)"
            , "Pizza con una base crujiente y dorada, cubierta con salsa de tomate y queso muzzarella derretido, acompañada de una colorida mezcla de vegetales frescos como pimientos, cebolla, champiñones y tomates en rodajas. Los tomates aportan jugosidad y un sabor ligeramente dulce, equilibrando perfectamente con los otros vegetales y el queso, creando una opción deliciosa y nutritiva."
            , Tipo.PIZZA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/pizza-vegetales.webp"));

        //      ------------Hamburguesas------------
        platos.add(new Plato("Hamburguesa Clásica de la Casa"
            , "Una hamburguesa clásica con una carne super jugosa y un sabor incomparable. Contiene pan de papa, doble carne jugosa, queso cheddar derretido, tomate, lechuga, pepino y salsa de la casa."
            , Tipo.HAMBURGUESA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/burger-clasica.webp"));
        platos.add(new Plato("Hamburguesa Bacon y Huevo"
            , "Un jugoso medallón de carne a la parrilla, acompañada de crujientes tiras de bacon y un huevo frito con la yema ligeramente líquida. Todo servido en un pan suave con queso cheddar derretido, lechuga fresca y mayonesa, creando una deliciosa combinación de sabores clásicos y texturas."
            , Tipo.HAMBURGUESA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/burger-bacon-egg.png"));
        platos.add(new Plato("Hamburguesa Cebolla y Bacon"
            , "Medallón de carne a la parrilla, cubierta con cebolla caramelizada que aporta un toque dulce y tiras crujientes de bacon. Servida en un pan suave con queso cheddar derretido y una ligera capa de mayonesa, esta hamburguesa combina sabores intensos y texturas deliciosas."
            , Tipo.HAMBURGUESA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/burger-bbq.webp"));
        platos.add(new Plato("Hamburguesa Pollo Crispy Simple"
            , "Pechuga de pollo empanada y frita hasta quedar crujiente por fuera y jugosa por dentro. Servida en un pan suave, acompañada de rodajas de tomate fresco, lechuga crocante y una capa de mayonesa cremosa para equilibrar los sabores. Simple, pero deliciosa."
            , Tipo.HAMBURGUESA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/burger-crispy-chicken.png"));
        platos.add(new Plato("Hamburguesa Pollo, Bacon y Cebolla Crispy"
            , "Pechuga de pollo empanada y frita hasta quedar extra crujiente, cubierta con tiras de bacon crocante, cebolla crispy dorada y dos generosas rodajas de queso provoleta derretido. Servida en un pan suave, esta hamburguesa ofrece una explosión de texturas y sabores intensos, perfecta para los amantes de las combinaciones irresistibles."
            , Tipo.HAMBURGUESA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/burger-chicken-bacon.png"));
        platos.add(new Plato("Hamburguesa Vegana Simple"
            , "Hamburguesa con un medallón vegano hecho a base de ingredientes que imitan la textura y sabor de la carne, servido con lechuga fresca, rodajas de tomate, cebolla morada crujiente y pepino. Todo en un pan vegano suave, acompañado de una salsa ligera, ofreciendo una opción deliciosa y sabrosa, 100% vegetal."
            , Tipo.HAMBURGUESA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/burger-vegan.web.png"));

        //      ------------Acompañamientos------------
        platos.add(new Plato("Papas Fritas Caseras"
            , "Papas cortadas en tiras y fritas, con opción de condimentos como paprika, ajo en polvo y romero."
            , Tipo.ACOMPAÑANMIENTO
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/acompañamineto-papas-fritas.png"));
        platos.add(new Plato("Aros de Cebolla"
            , "Cebolla rebozada y frita, con salsa barbacoa o mayonesa."
            , Tipo.ACOMPAÑANMIENTO
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/acompañamiento-onion-rings.png"));
        platos.add(new Plato("Papas con Cheddar y Bacon Triturado"
            , "Deliciosas papas al horno o fritas, cubiertas con una generosa capa de queso cheddar derretido y trocitos crujientes de bacon triturado."
            , Tipo.ACOMPAÑANMIENTO
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/acompañamiento-papas-cheddar-bacon.png"));

        //      ------------Ensaladas------------
        platos.add(new Plato("Ensalada César con Pollo"
            , "Ensalada de lechuga romana crujiente, acompañada de trozos de pollo a la parrilla, crutones dorados y queso parmesano rallado. Todo aderezado con una suave y cremosa salsa César, que mezcla mayonesa, ajo, anchoas y limón. Esta combinación ofrece una opción fresca y sabrosa, con una mezcla de texturas y sabores enriquecedores."
            , Tipo.ENSALADA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/Ensalada-cesar-con-pollo.png"));
        platos.add(new Plato("Ensalada Latina"
            , "Ensalada vibrante que combina lechuga fresca con tomate, aguacate, maíz, frijoles negros y cebolla roja. Adornada con cilantro fresco y acompañada de una vinagreta de limón y comino. Esta ensalada ofrece una explosión de sabores y texturas, con un toque refrescante y ligero."
            , Tipo.ENSALADA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/Ensalada-latina.webp"));
        platos.add(new Plato("Ensalada de Manzana, Queso Azul y Nuez"
            , "Ensalada fresca y equilibrada que combina rodajas de manzana crujiente con el sabor intenso y cremoso del queso azul, nueces tostadas para aportar crocante, y pasas dulces. Todo aliñado con un ligero toque de miel, que une los sabores en una mezcla perfecta de dulce, salado y fresco."
            , Tipo.ENSALADA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/ensalada manzana.webp"));

        //      ------------Bebidas------------
        //! Hay que ver bien que hacer con las bebidas, asi que solo pongo esto por ahora
        platos.add(new Plato("Coca-Cola 500ml"
            , "Disponibles en 500ml"
            , Tipo.BEBIDA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/bebeida-coca-medio.webp"));
        
            platos.add(new Plato("Coca-Cola 1.5L"
            , "Disponible en 1.5L"
            , Tipo.BEBIDA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/bebeida-coca-medio.webp"));
        
        platos.add(new Plato("Coca-Cola 2.25L"
            , "Disponibles en 2.25L"
            , Tipo.BEBIDA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/bebeida-coca-medio.webp"));
        
            platos.add(new Plato("Coca-Cola Zero 500Ml"
            , "Disponibles en 500ml"
            , Tipo.BEBIDA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/bebeida-coca-medio.webp"));
        
            platos.add(new Plato("Coca-Cola Zero 1.5L"
            , "Disponibles en 1.5L"
            , Tipo.BEBIDA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/bebeida-coca-medio.webp"));
        
            platos.add(new Plato("Coca-Cola Zero 2.25L"
            , "Disponibles en 2.25L"
            , Tipo.BEBIDA
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/bebeida-coca-medio.webp"));

        //      ------------Postres------------
        platos.add(new Plato("Flan Casero"
            , "Clásico flan de huevo, suave y cremoso, servido con una generosa porción de dulce de leche y, opcionalmente, un poco de crema chantilly."
            , Tipo.POSTRE
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/postre-flan.webp"));
        platos.add(new Plato("Alfajor de Maicena"
            , "Delicados y suaves alfajores hechos con una masa de maicena, que les da una textura ligera y desmenuzable. Rellenos con una generosa capa de dulce de leche, y luego cubiertos con un espolvoreo de azúcar impalpable o coco rallado."
            , Tipo.POSTRE
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/postre-alfajores.webp"));
        platos.add(new Plato("Arroz con Leche"
            , "Postre cremoso y reconfortante hecho con arroz cocido lentamente en leche, azúcar y una pizca de canela. Se aromatiza con cáscara de limón o vainilla, resultando en una textura suave y un sabor dulce y especiado. Perfecto para disfrutar frío o tibio."
            , Tipo.POSTRE
            , 1500D
            , 20
            , true
            , "IMAGENES BUEN SABOR/MENU/postre-arroz-con-leche.webp"));
    }

    public boolean savePlatos(PlatoRequestDTO platoDTO) {
        return true;
    }
}
