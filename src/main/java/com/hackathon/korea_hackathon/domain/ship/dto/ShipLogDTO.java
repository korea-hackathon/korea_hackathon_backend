package com.hackathon.korea_hackathon.domain.ship.dto;

import com.hackathon.korea_hackathon.domain.ship.entity.ShipLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShipLogDTO {

    private String createdTime;

    private String dataChannelId;

    private String boolV;

    private String strV;

    private String doubleV;

    private String valueFormat;

    public ShipLog toEntity(){

        this.createdTime = createdTime.substring(1, createdTime.length() - 1); // 작은따옴표 제거
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        LocalDateTime dateTime = LocalDateTime.parse(this.createdTime, formatter);
        return ShipLog.builder()
                .createdTime(dateTime)
                .dataChannelId(this.dataChannelId)
                .boolV(this.boolV)
                .strV(this.strV)
                .doubleV(this.doubleV)
                .valueFormat(this.valueFormat)
                .build();
    }
}
