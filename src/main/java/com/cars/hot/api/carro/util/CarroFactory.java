package com.cars.hot.api.carro.util;

import com.cars.hot.api.carro.entity.Carro;
import com.cars.hot.api.carro.scrapper.PosicaoDadosNaListaCarrosDoAnoEnum;
import com.cars.hot.api.utils.AbstractFactory;
import com.cars.hot.api.utils.Fabrica;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

@Component
public class CarroFactory implements Fabrica<Carro> {
    public static final String NOME = CarroFactory.class.getName();

    public CarroFactory() {
        registrarNaAbstractFactory();
    }

    @Override
    public void registrarNaAbstractFactory() {
        AbstractFactory.registrar(NOME, this);
    }

    @Override
    public Carro novoObjeto() {
        return new Carro();
    }

    public Carro novoObjeto(Element element) {
        String nome = element.child(PosicaoDadosNaListaCarrosDoAnoEnum.NOME.getPosicao()).text();
        String serie = element.child(PosicaoDadosNaListaCarrosDoAnoEnum.SERIE.getPosicao()).text();
        String posicao = element.child(PosicaoDadosNaListaCarrosDoAnoEnum.POSICAO_SERIE.getPosicao()).text().split("/")[0];

        return this.novoObjeto(nome, serie, posicao);
    }

    public Carro novoObjeto(String modelo, String serie, String posicaoSerie) {
        Carro carro = novoObjeto();
        carro.setModelo(modelo);
        carro.setSerie(0L);
        carro.setNumeroSerie(Long.parseLong(posicaoSerie));
        return carro;
    }
}
