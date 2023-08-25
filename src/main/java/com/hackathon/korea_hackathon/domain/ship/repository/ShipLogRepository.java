package com.hackathon.korea_hackathon.domain.ship.repository;

import com.hackathon.korea_hackathon.domain.ship.entity.ShipLog;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ShipLogRepository extends JpaRepository<ShipLog, Long> {

    @Query("SELECT s FROM ShipLog s WHERE s.createdTime <= :time AND s.dataChannelId = :dataChannelId ORDER BY s.createdTime DESC")
    List<ShipLog> findFirstByTimeBeforeAndDataChannelIdOrderByTimeDesc(
            @Param("createdTime") LocalDateTime time,
            @Param("dataChannelId") String dataChannelId
    );
}
