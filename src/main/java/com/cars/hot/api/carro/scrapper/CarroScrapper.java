package com.cars.hot.api.carro.scrapper;

import com.cars.hot.api.carro.entity.Carro;
import com.cars.hot.api.carro.util.CarroFactory;
import com.cars.hot.api.utils.AbstractFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarroScrapper {
    private static final Logger log = LoggerFactory.getLogger(CarroScrapper.class);
    @Value("${services.hotwheels-fandom.url}")
    private String urlFandom;
    @Value("${services.hotwheels-fandom.endpoint-lista-do-ano}")
    private String endpointListaDoAno;
    @Value("${services.hotwheels-fandom.selector-tabela-lista-carros-do-ano}")
    private String selectorListaDoAno;

    private Document getPaginaHtml(String url) throws IOException {
        log.info("Connecting with {}", url);
        return Jsoup.connect(url).get();
    }

    private String getUrlFandomListaDoAno(Object ano) {
        return urlFandom.concat(endpointListaDoAno.replace("{ANO}", ano.toString()));
    }

    public Document getPaginaListaCarrosDoAno(Object ano) throws IOException {
        return this.getPaginaHtml(this.getUrlFandomListaDoAno(ano));
    }

    public Elements getElementsDeListaDeCarrosPorAno(Object ano) throws IOException {
        return this.getPaginaListaCarrosDoAno(ano).select( "#" + selectorListaDoAno);
    }

    public List<Carro> getListaCarrosPorAno(String ano) throws IOException {
        List<Carro> carros = new ArrayList<>();

        Elements list = getElementsDeListaDeCarrosPorAno(ano);
        list.forEach(obj -> {
            CarroFactory factory = AbstractFactory.getFabrica(CarroFactory.NOME);
            carros.add(factory.novoObjeto(obj));
        });

        return carros.stream().distinct().toList();
    }
}
