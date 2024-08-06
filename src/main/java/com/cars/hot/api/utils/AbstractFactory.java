package com.cars.hot.api.utils;

import java.util.HashMap;

public class AbstractFactory {
    private static final HashMap<String, Fabrica<?>> factories = new HashMap<>();

    private AbstractFactory() {
    }

    public static <T> void registrar(String key, Fabrica<T> fabrica) {
        factories.put(key, fabrica);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getFabrica(String key) {
        return (T) factories.get(key);
    }
}
