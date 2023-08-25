package com.hackathon.korea_hackathon.domain.ship.service;

import com.hackathon.korea_hackathon.domain.ship.dto.LocationResponse;
import com.hackathon.korea_hackathon.domain.ship.dto.RpmResponse;
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

    private LocalDateTime curDate(){
        return LocalDateTime.now().minusMonths(1).minusDays(9);
    }
}
