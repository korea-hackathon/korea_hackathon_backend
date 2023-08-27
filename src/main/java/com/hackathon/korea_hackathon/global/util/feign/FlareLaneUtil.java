package com.hackathon.korea_hackathon.global.util.feign;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class FlareLaneUtil {

    private final FlareLaneFeignClient flareLaneFeignClient;

    public void sendMessage(String title, String body){
        FlareLaneRequest flareLaneRequest = new FlareLaneRequest(
                "segment",
                new ArrayList<>(Arrays.asList("fac7d338-0cad-4a82-9a3f-feb78f653f35")),
                title,
                body
        );
        flareLaneFeignClient.sendMessage(flareLaneRequest);
    }

}
