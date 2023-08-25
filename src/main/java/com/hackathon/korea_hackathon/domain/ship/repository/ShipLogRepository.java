package com.hackathon.korea_hackathon.domain.ship.repository;

import com.hackathon.korea_hackathon.domain.ship.entity.ShipLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipLogRepository extends JpaRepository<ShipLog, Long> {
}
