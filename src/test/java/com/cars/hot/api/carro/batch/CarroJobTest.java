package com.cars.hot.api.carro.batch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableAutoConfiguration
@ActiveProfiles("test")
class CarroJobTest {
    private final JobLauncher jobLauncher;
    private final CarroJob carroJob;

    @Autowired
    CarroJobTest(JobLauncher jobLauncher, CarroJob carroJob) {
        this.jobLauncher = jobLauncher;
        this.carroJob = carroJob;
    }

    @Test
    void testCarroJob() throws Exception {
        JobExecution jobExecution = jobLauncher.run(carroJob.getJob(), new JobParameters());

        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
    }
}