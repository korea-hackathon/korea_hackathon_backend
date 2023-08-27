package com.hackathon.korea_hackathon.domain.user.service;

import com.hackathon.korea_hackathon.domain.user.dto.response.UserTaskResponse;
import com.hackathon.korea_hackathon.global.util.feign.FlareLaneUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final FlareLaneUtil flareLaneUtil;

    public void notiLoad(){
        flareLaneUtil.sendMessage("EMERGENCY 🚨", "메인 엔진 부하가 90%를 넘었습니다");
    }

    public void notiLoadMobile(){
        flareLaneUtil.sendMessage("메인 엔진 부하가 90%를 넘었습니다 🚨", "문제가 없는지 확인해주시길 바랍니다");
    }

    public void notiDangerous(){
        flareLaneUtil.sendMessage("DANGEROUS ZONE 🚨", "사고다발 지역에 진입하였습니다");
    }

    public List<UserTaskResponse> getTaskFirst(){

        List<UserTaskResponse> userTaskResponses = new ArrayList<>();

        userTaskResponses.add(new UserTaskResponse("선박 기계 수리, 교체", "이상이 있는 선박의 기계를 수리해 주세요"));
        userTaskResponses.add(new UserTaskResponse("연료, 오일 및 기타 보급품 충당", "이상이 있는 선박의 기계를 수리해 주세요"));

        return userTaskResponses;
    }

    public List<UserTaskResponse> getTaskSecond(){

        List<UserTaskResponse> userTaskResponses = new ArrayList<>();

        userTaskResponses.add(new UserTaskResponse("M/E 점검", "메인엔진부하가 90% 를 넘었습니다."));
        userTaskResponses.add(new UserTaskResponse("선박 기계 수리, 교체", "이상이 있는 선박의 기계를 수리해 주세요"));
        userTaskResponses.add(new UserTaskResponse("연료, 오일 및 기타 보급품 충당", "이상이 있는 선박의 기계를 수리해 주세요"));

        return userTaskResponses;

    }
}
