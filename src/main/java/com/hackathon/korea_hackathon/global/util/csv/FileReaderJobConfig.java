package com.hackathon.korea_hackathon.global.util.csv;

import com.hackathon.korea_hackathon.domain.ship.dto.ShipLogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FileReaderJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final CsvReader csvReader;

    private final CsvScheduleWriter csvScheduleWriter;

    private static final int chunkSize = 100000;

    @Bean
    public Job csvScheduleJob(){
        return jobBuilderFactory.get("csvScheduleJob")
                .start(csvScheduleReaderStep())
                .build();
    }

    @Bean
    public Step csvScheduleReaderStep(){
        return stepBuilderFactory.get("csvScheduleReaderStep")
                //<reader에 넘겨줄 타입, writer에 넙겨줄 타입>
                .<ShipLogDTO, ShipLogDTO>chunk(chunkSize)
                .reader(csvReader.csvScheduleReader())
                .writer(csvScheduleWriter)
                .allowStartIfComplete(true)
                .build();
    }
}
