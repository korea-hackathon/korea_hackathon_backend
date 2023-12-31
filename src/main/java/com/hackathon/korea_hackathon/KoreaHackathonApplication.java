package com.hackathon.korea_hackathon;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableBatchProcessing
@SpringBootApplication
public class KoreaHackathonApplication {

    public static void main(String[] args) {
        SpringApplication.run(KoreaHackathonApplication.class, args);
    }

}
