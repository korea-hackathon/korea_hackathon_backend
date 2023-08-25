package com.hackathon.korea_hackathon.global.util.csv.vdr;

import com.hackathon.korea_hackathon.domain.ship.dto.ShipLogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@RequiredArgsConstructor
public class CsvReader {

    /**
     * 학사일정 파일 읽기
     */
    @Bean
    public FlatFileItemReader<ShipLogDTO> csvScheduleReader(){
        /* 파일읽기 */
        FlatFileItemReader<ShipLogDTO> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new ClassPathResource("/file/csv/VDR1.csv")); //읽을 파일 경로 지정
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setEncoding("UTF-8"); //인토딩 설정

        /* defaultLineMapper: 읽으려는 데이터 LineMapper을 통해 Dto로 매핑 */
        DefaultLineMapper<ShipLogDTO> defaultLineMapper = new DefaultLineMapper<>();

        /* delimitedLineTokenizer : csv 파일에서 구분자 지정하고 구분한 데이터 setNames를 통해 각 이름 설정 */
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer(","); //csv 파일에서 구분자
        delimitedLineTokenizer.setNames("createdTime", "dataChannelId", "boolV","strV","doubleV","valueFormat"); //행으로 읽은 데이터 매칭할 데이터 각 이름
        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer); //lineTokenizer 설정

        /* beanWrapperFieldSetMapper: 매칭할 class 타입 지정 */
        BeanWrapperFieldSetMapper<ShipLogDTO> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(ShipLogDTO.class);

        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper); //fieldSetMapper 지정

        flatFileItemReader.setLineMapper(defaultLineMapper); //lineMapper 지정

        return flatFileItemReader;

    }
}