package com.cars.hot.api.utils;

public interface Fabrica<T> {
    void registrarNaAbstractFactory();
    T novoObjeto();
}
