package com.hackathon.korea_hackathon.domain.ship.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataType {

    WIND_SPEED("/VDR/WIMWV/WIMWV_CH3"),

    LATITUDE("/VDR/GPGGA/GPGGA_CH2"),

    LONGITUDE("/VDR/GPGGA/GPGGA_CH4"),

    RPM("/AMS/AMS/MC022");

    private final String date;


}
