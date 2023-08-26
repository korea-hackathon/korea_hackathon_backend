package com.hackathon.korea_hackathon.domain.user.controller;

import com.hackathon.korea_hackathon.domain.user.dto.response.UserTaskResponse;
import com.hackathon.korea_hackathon.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserRepository {

    private final UserService userService;

    @PostMapping("/user/noti-computer")
    public void noti() {
        userService.notiLoad();
    }

    @PostMapping("/user/noti-phone")
    public void notiPhone() {
        userService.notiLoadMobile();
    }

    @GetMapping("/user/get-task-first")
    public List<UserTaskResponse> getTaskFirst() {
        return userService.getTaskFirst();
    }

    @GetMapping("/user/get-task-second")
    public List<UserTaskResponse> getTaskSecond(){
        return userService.getTaskSecond();
    }
}
