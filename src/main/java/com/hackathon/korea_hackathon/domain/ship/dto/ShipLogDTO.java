package com.hackathon.korea_hackathon.domain.ship.dto;

import com.hackathon.korea_hackathon.domain.ship.entity.ShipLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        return ShipLog.builder()
                .createdTime(this.createdTime)
                .dataChannelId(this.dataChannelId)
                .boolV(this.boolV)
                .strV(this.strV)
                .doubleV(this.doubleV)
                .valueFormat(this.valueFormat)
                .build();
    }
}
