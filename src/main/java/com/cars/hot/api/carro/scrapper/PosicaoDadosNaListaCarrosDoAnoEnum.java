package com.cars.hot.api.carro.scrapper;

import lombok.Getter;

@Getter
public enum PosicaoDadosNaListaCarrosDoAnoEnum {
    NOME(2), SERIE(3), POSICAO_SERIE(4);
    private final Integer posicao;

    PosicaoDadosNaListaCarrosDoAnoEnum(Integer posicao) {
        this.posicao = posicao;
    }
}
