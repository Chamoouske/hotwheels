package com.cars.hot.api.carro.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.stereotype.Component;

@Component
public class CarroJob {
    public static final String NOME = CarroJob.class.getSimpleName();
    private final JobRepository jobRepository;
    private final CarroStepper carroStepper;

    public CarroJob(JobRepository jobRepository, CarroStepper carroStepper) {
        this.jobRepository = jobRepository;
        this.carroStepper = carroStepper;
    }

    public Job getJob() {
        return new JobBuilder(NOME, jobRepository)
                .start(carroStepper.getStep())
                .build();
    }
}
