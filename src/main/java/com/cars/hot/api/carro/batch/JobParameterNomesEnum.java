package com.cars.hot.api.carro.batch;

import lombok.Getter;

@Getter
public enum JobParameterNomesEnum {
    LISTA_CARROS_POR_ANO("listaPorAno");
    private final String descricao;

    JobParameterNomesEnum(String descricao) {
        this.descricao = descricao;
    }
}
