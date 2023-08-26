package com.hackathon.korea_hackathon.domain.ship.service;

import com.hackathon.korea_hackathon.domain.ship.dto.*;
import com.hackathon.korea_hackathon.domain.ship.entity.DataType;
import com.hackathon.korea_hackathon.domain.ship.entity.ShipLog;
import com.hackathon.korea_hackathon.domain.ship.repository.ShipLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ShipLogService {

    private final ShipLogRepository shipLogRepository;

    public WindSpeedResponse getCurWindSpeed(){

        String windSpeed = "";

        LocalDateTime now = curDate();

        PageRequest pageRequest = PageRequest.of(0, 1); // 첫 페이지에서 한 개의 결과만 가져옵니다.
        List<ShipLog> windSpeed1 = shipLogRepository.findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(now, DataType.WIND_SPEED.getDate());

        if(!windSpeed1.isEmpty()){
            ShipLog mostRecent = windSpeed1.get(0);
            windSpeed = mostRecent.getDoubleV();
        }
        return new WindSpeedResponse(windSpeed);
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
            ShipLog mostRecent = geRpm2.get(0);
            geRpmTwo = mostRecent.getDoubleV();
        }

        List<ShipLog> geRpm3 = shipLogRepository.findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(now, DataType.GE_RPM3.getDate());

        if(!geRpm3.isEmpty()){
            ShipLog mostRecent = geRpm3.get(0);
            geRpmThree = mostRecent.getDoubleV();
        }

        return new GeRpmResponse(geRpmOne, geRpmTwo, geRpmThree);

    }

    public GeLoadResponse getCurGeLoad(){

        String geLoadOne = "";
        String geLoadTwo = "";
        String geLoadThree = "";

        LocalDateTime now = curDate();
        PageRequest pageRequest = PageRequest.of(0, 1); // 첫 페이지에서 한 개의 결과만 가져옵니다.

        List<ShipLog> geLoad1 = shipLogRepository.findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(now, DataType.GE_LOAD1.getDate());

        if(!geLoad1.isEmpty()){
            ShipLog mostRecent = geLoad1.get(0);

            geLoadOne = mostRecent.getDoubleV();
        }

        List<ShipLog> geLoad2 = shipLogRepository.findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(now, DataType.GE_LOAD2.getDate());

        if(!geLoad2.isEmpty()){
            ShipLog mostRecent = geLoad2.get(0);
            geLoadTwo = mostRecent.getDoubleV();
        }

        List<ShipLog> geLoad3 = shipLogRepository.findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(now, DataType.GE_LOAD3.getDate());

        if(!geLoad3.isEmpty()){
            ShipLog mostRecent = geLoad3.get(0);
            geLoadThree = mostRecent.getDoubleV();
        }

        return new GeLoadResponse(geLoadOne, geLoadTwo, geLoadThree);

    }

    public List<LocationResponse> getDangerousZone(){

        List<LocationResponse> locationResponses = new ArrayList<>();

        LocationResponse curLocation = getCurLocation();

        locationResponses.add(new LocationResponse(
            Double.toString(Double.parseDouble(curLocation.getLatitude()) + 1.0),
                Double.toString(Double.parseDouble(curLocation.getLongitude()) + 1.0)
        ));

        locationResponses.add(new LocationResponse(
                Double.toString(Double.parseDouble(curLocation.getLatitude()) + 5.0),
                Double.toString(Double.parseDouble(curLocation.getLongitude()) - 5.0)
        ));

        locationResponses.add(new LocationResponse(
                Double.toString(Double.parseDouble(curLocation.getLatitude()) + 12.0),
                Double.toString(Double.parseDouble(curLocation.getLongitude()) + 10.0)
        ));
        return locationResponses;
    }

    private LocalDateTime curDate(){
        ZonedDateTime curDate = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        return curDate.minusMonths(1).minusDays(8).toLocalDateTime();
    }
}
