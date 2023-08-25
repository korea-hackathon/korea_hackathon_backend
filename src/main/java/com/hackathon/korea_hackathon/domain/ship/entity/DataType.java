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

    //엔진 rpm
    RPM("/AMS/AMS/MC022"),

    //엔진 부하
    LOAD("/AMS/AMS/MC043"),

    //수온
    WATER_TEMP("/AMS/AMS/MW001"),

    //물쌀
    WATER_SPEED("/VDR/VDVBW/VDVBW_CH1"),

    //전력 rpm
    GE_RPM1("/AMS/AMS/GE146"),
    GE_RPM2("/AMS/AMS/GE246"),
    GE_RPM3("/AMS/AMS/GE346");

    private final String date;

}
