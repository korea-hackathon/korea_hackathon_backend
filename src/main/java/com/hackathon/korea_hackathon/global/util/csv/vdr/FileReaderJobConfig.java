package com.hackathon.korea_hackathon.global.util.csv.vdr;

import com.hackathon.korea_hackathon.domain.ship.dto.ShipLogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FileReaderJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final CsvReader csvReader;

    private final CsvScheduleWriter csvScheduleWriter;

    private static final int chunkSize = 1000; //데이터 처리할 row size


    /**
     * 학사일정 저장 Job
     * Job은 여러 Step을 가질 수 있음
     */
    @Bean
    public Job csvScheduleJob(){
        return jobBuilderFactory.get("csvScheduleJob")
                .start(csvScheduleReaderStep())
                .build();
    }


    /**
     * csv 파일 읽고 DB에 쓰는 Step
     */
    @Bean
    public Step csvScheduleReaderStep(){
        return stepBuilderFactory.get("csvScheduleReaderStep")
                .<ShipLogDTO, ShipLogDTO>chunk(chunkSize)
                .reader(csvReader.csvScheduleReader())
                .writer(csvScheduleWriter)
                .build();
    }

}