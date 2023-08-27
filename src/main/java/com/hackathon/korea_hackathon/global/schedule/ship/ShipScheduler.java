package com.hackathon.korea_hackathon.global.schedule.ship;

import com.hackathon.korea_hackathon.domain.ship.dto.WindSpeedResponse;
import com.hackathon.korea_hackathon.domain.ship.service.ShipLogService;
import com.hackathon.korea_hackathon.global.util.feign.FlareLaneUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShipScheduler {

    private final ShipLogService shipLogService;

    private final FlareLaneUtil flareLaneUtil;

    @Scheduled(cron = "0/5 * * * * ?")
    public void windSpeedAlert(){
        WindSpeedResponse curWindSpeed = shipLogService.getCurWindSpeed();
        if(Double.parseDouble(curWindSpeed.getWindSpeed()) >= 15.0){
            extracted();
        }
    }

    public void extracted() {
        flareLaneUtil.sendMessage("풍속 경고 🚨", "현재 풍속이 15m/s 이상 입니다");
    }
}