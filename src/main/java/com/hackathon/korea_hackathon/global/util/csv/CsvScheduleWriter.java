package com.hackathon.korea_hackathon.global.util.csv;

import com.hackathon.korea_hackathon.domain.ship.dto.ShipLogDTO;
import com.hackathon.korea_hackathon.domain.ship.entity.ShipLog;
import com.hackathon.korea_hackathon.domain.ship.repository.ShipLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Configuration
public class CsvScheduleWriter implements ItemWriter<ShipLogDTO> {

    private final ShipLogRepository shipLogRepository;

    @Override
    public void write(List<? extends ShipLogDTO> items) throws Exception {
        List<ShipLog> shipLogList = new ArrayList<>();

        items.forEach(
                getShipLogDto ->  {
                    ShipLog shipLog = getShipLogDto.toEntity();
                    shipLogList.add(shipLog);
                }
        );

        shipLogRepository.saveAll(shipLogList);
    }
}
