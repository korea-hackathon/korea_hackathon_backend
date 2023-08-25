package com.hackathon.korea_hackathon.domain.ship.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataType {
    
    //풍속
    WIND_SPEED("/VDR/WIMWV/WIMWV_CH3"),

    //위도
    LATITUDE("/VDR/GPGGA/GPGGA_CH2"),

    //경도
    LONGITUDE("/VDR/GPGGA/GPGGA_CH4"),

    //rpm
    RPM("/AMS/AMS/MC022"),

    //부하
    LOAD("/AMS/AMS/MC043");

    private final String date;

}
