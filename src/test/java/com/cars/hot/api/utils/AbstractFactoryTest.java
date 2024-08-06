package com.cars.hot.api.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryTest {

    @Test
    void registrar() {
        Fabrica<?> fabrica = new Fabrica<>() {
            @Override
            public void registrarNaAbstractFactory() {
                AbstractFactory.registrar("FabricaTest", this);
            }

            @Override
            public Object novoObjeto() {
                return null;
            }
        };

        AbstractFactory.registrar("FabricaTest", fabrica);

        assertNotNull(AbstractFactory.getFabrica("FabricaTest"));
    }
}