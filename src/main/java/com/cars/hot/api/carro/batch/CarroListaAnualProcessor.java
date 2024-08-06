package com.cars.hot.api.carro.batch;

import com.cars.hot.api.carro.entity.Carro;
import com.cars.hot.api.carro.scrapper.CarroScrapper;
import org.jsoup.select.Elements;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarroListaAnualProcessor implements ItemProcessor<Elements, List<Carro>> {
    private final CarroScrapper carroScrapper;

    public CarroListaAnualProcessor(CarroScrapper carroScrapper) {
        this.carroScrapper = carroScrapper;
    }

    @Override
    public List<Carro> process(Elements item) throws Exception {
        return carroScrapper.getListaCarrosDeElements(item);
    }
}
