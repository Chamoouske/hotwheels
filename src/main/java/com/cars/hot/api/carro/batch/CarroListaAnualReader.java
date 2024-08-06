package com.cars.hot.api.carro.batch;

import com.cars.hot.api.carro.scrapper.CarroScrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.select.Elements;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class CarroListaAnualReader implements ItemReader<Elements> {
    private static final Logger log = LogManager.getLogger(CarroListaAnualReader.class);
    private final CarroScrapper carroScrapper;
    private final AtomicInteger count = new AtomicInteger(0);
    private List<String> listAno;

    public CarroListaAnualReader(CarroScrapper carroScrapper) {
        this.carroScrapper = carroScrapper;
    }

    @BeforeStep
    @SuppressWarnings("unchecked")
    public void beforeStep(StepExecution stepExecution) {
        count.set(0);
        JobParameter<?> parameter = stepExecution.getJobExecution().getJobParameters().getParameter(JobParameterNomesEnum.LISTA_CARROS_POR_ANO.getDescricao());
        if (Objects.nonNull(parameter))
            listAno = (List<String>) parameter.getValue();
    }

    @Override
    public Elements read() throws Exception {
        log.info("Reading...");
        AtomicReference<Elements> reference = new AtomicReference<>();
        if (Objects.nonNull(listAno) && listAno.size() > count.get()) {
            reference.set(carroScrapper.getElementsDeListaDeCarrosPorAno(listAno.get(count.getAndIncrement())));
        }

        return reference.get();
    }
}
