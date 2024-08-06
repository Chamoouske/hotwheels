package com.cars.hot.api.carro.batch;

import com.cars.hot.api.carro.entity.Carro;
import com.cars.hot.api.carro.repository.CarroRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarroListaAnualWriter implements ItemWriter<List<Carro>> {
    private final CarroRepository carroRepository;

    public CarroListaAnualWriter(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @Override
    public void write(Chunk<? extends List<Carro>> chunk) {
        chunk.getItems().forEach(carroRepository::saveAll);
    }
}
