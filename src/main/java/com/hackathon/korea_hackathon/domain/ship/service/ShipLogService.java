package com.hackathon.korea_hackathon.domain.ship.service;

import com.hackathon.korea_hackathon.domain.ship.dto.*;
import com.hackathon.korea_hackathon.domain.ship.entity.DataType;
import com.hackathon.korea_hackathon.domain.ship.entity.ShipLog;
import com.hackathon.korea_hackathon.domain.ship.repository.ShipLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ShipLogService {

    private final ShipLogRepository shipLogRepository;

    public String findCurWindSpeed(){


        LocalDateTime now = curDate();
        System.out.println(now);
        PageRequest pageRequest = PageRequest.of(0, 1); // 첫 페이지에서 한 개의 결과만 가져옵니다.
        List<ShipLog> logs = shipLogRepository.findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(now, DataType.WIND_SPEED.getDate());

        if (!logs.isEmpty()) {
            ShipLog mostRecent = logs.get(0); // 가장 최근 항목을 가져옵니다.
            return mostRecent.getDoubleV();
        }
        return null;
    }

    public LocationResponse getCurLocation(){

        String latitude = "";

        String longitude ="";

        LocalDateTime now = curDate();
        PageRequest pageRequest = PageRequest.of(0, 1); // 첫 페이지에서 한 개의 결과만 가져옵니다.
        List<ShipLog> latitude1 = shipLogRepository.findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(now, DataType.LATITUDE.getDate());

        if(!latitude1.isEmpty()){
            ShipLog mostRecent = latitude1.get(0);
            latitude = mostRecent.getDoubleV();
        }
        List<ShipLog> longitude1 = shipLogRepository.findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(now, DataType.LONGITUDE.getDate());

        if(!longitude1.isEmpty()){
            ShipLog mostRecent = longitude1.get(0);
            longitude = mostRecent.getDoubleV();
        }

        return new LocationResponse(latitude, longitude);
    }

    public RpmResponse getCurRpm(){

        String rpm = "";

        LocalDateTime now = curDate();
        PageRequest pageRequest = PageRequest.of(0, 1); // 첫 페이지에서 한 개의 결과만 가져옵니다.
        List<ShipLog> rpm1 = shipLogRepository.findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(now, DataType.RPM.getDate());

        if(!rpm1.isEmpty()){
            ShipLog mostRecent = rpm1.get(0);
            rpm = mostRecent.getDoubleV();
        }

        return new RpmResponse(rpm);
    }

    public LoadResponse getCurLoad(){

        String load = "";

        LocalDateTime now = curDate();
        PageRequest pageRequest = PageRequest.of(0, 1); // 첫 페이지에서 한 개의 결과만 가져옵니다.
        List<ShipLog> load1 = shipLogRepository.findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(now, DataType.LOAD.getDate());

        if(!load1.isEmpty()){
            ShipLog mostRecent = load1.get(0);
            load = mostRecent.getDoubleV();
        }

        return new LoadResponse(load);
    }

    public WaterTempResponse getCurWaterTemp(){

        String waterTemp = "";

        LocalDateTime now = curDate();
        PageRequest pageRequest = PageRequest.of(0, 1); // 첫 페이지에서 한 개의 결과만 가져옵니다.
        List<ShipLog> waterTemp1 = shipLogRepository.findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(now, DataType.WATER_TEMP.getDate());

        if(!waterTemp1.isEmpty()){
            ShipLog mostRecent = waterTemp1.get(0);
            waterTemp = mostRecent.getDoubleV();
        }

        return new WaterTempResponse(waterTemp);
    }

    public WaterSpeedResponse getCurWaterSpeed(){

        String waterSpeed = "";

        LocalDateTime now = curDate();
        PageRequest pageRequest = PageRequest.of(0, 1); // 첫 페이지에서 한 개의 결과만 가져옵니다.
        List<ShipLog> waterSpeed1 = shipLogRepository.findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(now, DataType.WATER_SPEED.getDate());

        if(!waterSpeed1.isEmpty()){
            ShipLog mostRecent = waterSpeed1.get(0);
            waterSpeed = mostRecent.getDoubleV();
        }

        return new WaterSpeedResponse(waterSpeed);
    }

    public GeRpmResponse getCurGeRpm(){

        String geRpmOne = "";
        String geRpmTwo = "";
        String geRpmThree = "";

        LocalDateTime now = curDate();
        PageRequest pageRequest = PageRequest.of(0, 1); // 첫 페이지에서 한 개의 결과만 가져옵니다.

        List<ShipLog> geRpm1 = shipLogRepository.findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(now, DataType.GE_RPM1.getDate());

        if(!geRpm1.isEmpty()){
            ShipLog mostRecent = geRpm1.get(0);
            geRpmOne = mostRecent.getDoubleV();
        }

        List<ShipLog> geRpm2 = shipLogRepository.findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(now, DataType.GE_RPM2.getDate());

        if(!geRpm2.isEmpty()){
            ShipLog mostRecent = geRpm1.get(0);
            geRpmOne = mostRecent.getDoubleV();
        }

        List<ShipLog> geRpm3 = shipLogRepository.findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(now, DataType.GE_RPM3.getDate());

        if(!geRpm3.isEmpty()){
            ShipLog mostRecent = geRpm1.get(0);
            geRpmOne = mostRecent.getDoubleV();
        }

        return new GeRpmResponse(geRpmOne, geRpmTwo, geRpmThree);

    }

    private LocalDateTime curDate(){
        return LocalDateTime.now().minusMonths(1).minusDays(9);
    }
}
