package com.hackathon.korea_hackathon.global.util.feign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class FlareLaneRequest {

    private String targetType;

    private List<String> targetIds;

    private String title;

    private String body;

}
