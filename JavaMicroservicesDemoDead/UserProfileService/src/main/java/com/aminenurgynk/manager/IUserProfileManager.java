package com.aminenurgynk.manager;

import com.aminenurgynk.dto.request.UserProfileSaveRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.aminenurgynk.constant.EndPoint.SAVE;


public interface IUserProfileManager {

    @PostMapping(SAVE)
    ResponseEntity<Boolean> save(@RequestBody UserProfileSaveRequestDto dto);
}
