package com.hackathon.korea_hackathon.global.util.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "flarelaneclient",
        url = "https://api.flarelane.com/v1/projects/69fd408c-75cb-4e90-ae68-6e5bfd84fcbc/notifications"
)
public interface FlareLaneFeignClient {
    @PostMapping(consumes = "application/json", headers = "Authorization=Bearer ggVNYoL_PHG1_4PDcfAz3")
    public void sendMessage(@RequestBody FlareLaneRequest request);
}
