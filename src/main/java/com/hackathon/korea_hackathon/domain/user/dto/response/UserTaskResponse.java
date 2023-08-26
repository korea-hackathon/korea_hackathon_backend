package com.hackathon.korea_hackathon.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UserTaskResponse {

    private String title;

    private String description;

}
