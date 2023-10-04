package com.aminenurgynk.controller;

import com.aminenurgynk.dto.request.UserProfileSaveRequestDto;
import com.aminenurgynk.repository.entity.UserProfile;
import com.aminenurgynk.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.aminenurgynk.constant.EndPoint.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER)
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody UserProfileSaveRequestDto dto){
        return ResponseEntity.ok(userProfileService.doSave(dto));
    }

    @PostMapping(GETALL)
    public ResponseEntity<List<UserProfile>> findAll(){

        return ResponseEntity.ok(userProfileService.findAll());
    }

    @GetMapping("/hi")
    public String hello(){return "Hi API";}

    @GetMapping("/getname")
    public ResponseEntity<String> getUpperCase(String firstName){
        return ResponseEntity.ok(userProfileService.getUpperCase(firstName));
    }

    @GetMapping("/clearcache")
    public ResponseEntity<Void> clearCache(){
        userProfileService.clearCache();
        return ResponseEntity.ok().build();
    }

}
