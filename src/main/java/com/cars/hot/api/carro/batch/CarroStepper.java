package com.cars.hot.api.carro.batch;

import com.cars.hot.api.carro.entity.Carro;
import org.jsoup.select.Elements;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class CarroStepper {
    public static final String NOME = CarroStepper.class.getSimpleName();
    private static final Integer NUMERO_PADRAO_CHUNKS = 1;
    private final JobRepository jobRepository;
    private final DataSourceTransactionManager transactionManager;
    private final CarroListaAnualReader reader;
    private final CarroListaAnualProcessor processor;
    private final CarroListaAnualWriter writer;
    private Step step;

    public CarroStepper(JobRepository jobRepository, DataSourceTransactionManager transactionManager,
                        CarroListaAnualReader reader, CarroListaAnualProcessor processor, CarroListaAnualWriter writer) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.reader = reader;
        this.processor = processor;
        this.writer = writer;
    }

    public Step getStep() {
        if (Objects.isNull(this.step)) {
            this.step = new StepBuilder(NOME, jobRepository)
                    .<Elements, List<Carro>>chunk(NUMERO_PADRAO_CHUNKS, transactionManager)
                    .reader(reader)
                    .processor(processor)
                    .writer(writer)
                    .build();
        }

        return this.step;
    }
}
