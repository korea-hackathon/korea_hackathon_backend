package com.hackathon.korea_hackathon.domain.ship.controller;

import com.hackathon.korea_hackathon.domain.ship.dto.LocationResponse;
import com.hackathon.korea_hackathon.domain.ship.dto.RpmResponse;
import com.hackathon.korea_hackathon.domain.ship.service.ShipLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ShipLogController {

    private final ShipLogService shipLogService;

    @GetMapping("/wind-speed")
    public String getWindSpeed(){
        return shipLogService.findCurWindSpeed();
    }

    @GetMapping("/cur/location")
    public LocationResponse getCurLocation(){
        return shipLogService.getCurLocation();
    }

    @GetMapping("/cur/rpm")
    public RpmResponse getCurRpm(){
        return shipLogService.getCurRpm();
    }

}
