package com.cars.hot.api.carro.util;

import com.cars.hot.api.carro.entity.Carro;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarroFactoryTest {
    private final CarroFactory carroFactory = new CarroFactory();

    @Test
    void novoObjeto() {
        Element element = new Element("tr");
        element.append("""
                <td>HRY51</td>
                 <td>001</td>
                 <td><a href="/wiki/Mazda_Autozam" title="Mazda Autozam">Mazda Autozam</a></td>
                 <td bgcolor="grey"><a href="/wiki/HW_Dream_Garage_Mini_Collection_(2024)" title="HW Dream Garage Mini Collection (2024)"><font color="black">HW Dream Garage</font></a></td>
                 <td>3/5</td>
                 <td></td>""");

        Carro carro = carroFactory.novoObjeto(element);

        assertEquals("Mazda Autozam", carro.getModelo());
    }
}