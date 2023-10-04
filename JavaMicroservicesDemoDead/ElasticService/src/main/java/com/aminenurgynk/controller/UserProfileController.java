package com.aminenurgynk.controller;

import com.aminenurgynk.dto.request.PagingRequestDto;
import com.aminenurgynk.repository.entity.UserProfile;
import com.aminenurgynk.dto.request.UserProfileSaveRequestDto;
import com.aminenurgynk.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.aminenurgynk.constant.EndPoints.*;

//  http://localhost:9100/elastic/user
@RequiredArgsConstructor
@RestController
@RequestMapping(ELASTIC+USER)
public class UserProfileController {

    private final UserProfileService userProfileService;

    //  http://localhost:9100/elastic/user/save
    @PostMapping(SAVE)
    public ResponseEntity<Void> addUser(@RequestBody UserProfileSaveRequestDto dto) {
        userProfileService.saveDto(dto);
        return ResponseEntity.ok().build();
    }

    //  http://localhost:9100/elastic/user/getall
    @GetMapping(GETALL)
    public ResponseEntity<Iterable<UserProfile>> findAll() {
        return ResponseEntity.ok(userProfileService.findAll());
    }

    //  http://localhost:9100/elastic/user/getallpage
    @PostMapping(GETALLPAGE)
    public ResponseEntity<Page<UserProfile>> findAll(@RequestBody PagingRequestDto dto) {
        return ResponseEntity.ok(userProfileService.findAll(dto));
    }

    // http://localhost:9100/elastic/user/hi
    @GetMapping("/hi")
    public String hi() {
        return "Hi: UserProfile Service";
    }


    //  http://localhost:9100/elastic/user/getallvip
    @GetMapping(GETALLVIP)
    @PreAuthorize("hasAuthority('VIP')")
    public ResponseEntity<Iterable<UserProfile>> getAllVip() {
        return ResponseEntity.ok(userProfileService.findAll());
    }


    //  http://localhost:9100/elastic/user/getallmanager
    @GetMapping(GETALLMANAGER)
    @PreAuthorize("hasAuthority('MANAGER')")
    public ResponseEntity<Iterable<UserProfile>> getAllManager() {
        return ResponseEntity.ok(userProfileService.findAll());
    }


    //  http://localhost:9100/elastic/user/delete
    @DeleteMapping(DELETE)
    public ResponseEntity<Void> deleteUser(@RequestBody Long authid) {
        userProfileService.deleteByAuthId(authid);
        return ResponseEntity.ok().build();


    }

}
