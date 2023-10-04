package com.aminenurgynk.manager;

import com.aminenurgynk.repository.entity.UserProfile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.aminenurgynk.constant.EndPoint.*;

@FeignClient(name = "elastic-service-manager",
url = "http://localhost:9100/elastic/user",
decode404 = true)
public interface IElasticServiceManager {

    @PostMapping(SAVE)
    ResponseEntity<Boolean> addUser(@RequestBody UserProfile userProfile);
}
