package com.hackathon.korea_hackathon.global.util.csv.ams;

import com.hackathon.korea_hackathon.domain.ship.dto.ShipLogDTO;
import com.hackathon.korea_hackathon.global.util.csv.vdr.CsvReader;
import com.hackathon.korea_hackathon.global.util.csv.vdr.CsvScheduleWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AmsFileReaderJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final AmsCsvReader csvReader;

    private final AmsCsvScheduleWriter csvScheduleWriter;

    private static final int chunkSize = 1000; //데이터 처리할 row size


    /**
     * 학사일정 저장 Job
     * Job은 여러 Step을 가질 수 있음
     */
    @Bean
    public Job amsCsvScheduleJob(){
        return jobBuilderFactory.get("csvScheduleJob1")
                .start(amsCsvScheduleReaderStep())
                .build();
    }


    /**
     * csv 파일 읽고 DB에 쓰는 Step
     */
    @Bean
    public Step amsCsvScheduleReaderStep(){
        return stepBuilderFactory.get("csvScheduleReaderStep1")
                .<ShipLogDTO, ShipLogDTO>chunk(chunkSize)
                .reader(csvReader.amsCsvScheduleReader())
                .writer(csvScheduleWriter)
                .build();
    }

}