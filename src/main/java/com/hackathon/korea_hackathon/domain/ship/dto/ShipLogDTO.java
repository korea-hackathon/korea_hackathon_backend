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

    private String policyID;

    private String statecode;

    private String county;

    public ShipLog toEntity(){
        return ShipLog.builder()
                .policyID(this.policyID)
                .statecode(this.statecode)
                .county(this.county)
                .build();
    }
}
