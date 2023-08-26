package com.hackathon.korea_hackathon.domain.ship.controller;

import com.hackathon.korea_hackathon.domain.ship.dto.*;
import com.hackathon.korea_hackathon.domain.ship.service.ShipLogService;
import com.hackathon.korea_hackathon.global.schedule.ship.ShipScheduler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ShipLogController {

    private final ShipScheduler shipScheduler;

    private final ShipLogService shipLogService;

    @GetMapping("/cur/wind-speed")
    public WindSpeedResponse getWindSpeed() {
        return shipLogService.getCurWindSpeed();
    }

    @GetMapping("/cur/location")
    public LocationResponse getCurLocation() {
        return shipLogService.getCurLocation();
    }

    @GetMapping("/cur/rpm")
    public RpmResponse getCurRpm() {
        return shipLogService.getCurRpm();
    }

    @GetMapping("/cur/load")
    public LoadResponse getCurLoad() {
        return shipLogService.getCurLoad();
    }

    @GetMapping("/cur/waterTemp")
    public WaterTempResponse getCurWaterTemp() {
        return shipLogService.getCurWaterTemp();
    }

    @GetMapping("/cur/waterSpeed")
    public WaterSpeedResponse getCurWaterSpeed() {
        return shipLogService.getCurWaterSpeed();
    }

    @GetMapping("/cur/geRpm")
    public GeRpmResponse getCurGeRpm() {
        return shipLogService.getCurGeRpm();
    }

    @GetMapping("/cur/geLoad")
    public GeLoadResponse getCurGeLoad() {
        return shipLogService.getCurGeLoad();
    }

    @GetMapping("/dangerous-zone")
    public List<LocationResponse> getDangerousZone() {
        return shipLogService.getDangerousZone();
    }

    @GetMapping("/cur/fuel")
    public FuelResponse getFuel() {
        return shipLogService.getFuel();
    }

    @PostMapping("/wind-speed/noti")
    public void windSpeedNoti(){
        shipScheduler.extracted();
    }
}
