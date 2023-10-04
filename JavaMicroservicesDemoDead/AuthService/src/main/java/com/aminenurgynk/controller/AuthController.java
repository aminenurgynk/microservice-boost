package com.aminenurgynk.controller;

import com.aminenurgynk.dto.request.LoginRequestDto;
import com.aminenurgynk.dto.request.RegisterRequestDto;
import com.aminenurgynk.exception.AuthServiceException;
import com.aminenurgynk.exception.ErrorType;
import com.aminenurgynk.repository.entity.Auth;
import com.aminenurgynk.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.aminenurgynk.constant.EndPoint.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {

    private final AuthService authService;


    @PostMapping(LOGIN)
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequestDto dto){
        return ResponseEntity.ok(authService.login(dto));
    }
    @PostMapping (REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto dto){
/*        Auth auth = authService.save(
          Auth.builder()
                  .username(dto.getUsername())
                  .email(dto.getEmail())
                  .password(dto.getPassword())
                  .build());*/
        if(!dto.getPassword().equals(dto.getRepassword())) throw new AuthServiceException(ErrorType.REGISTER_PASSWORD_MISMACTH);
        else return ResponseEntity.ok(authService.register(dto));


    }
/*  Tokensiz
    @PostMapping(GETALL)
    public ResponseEntity<List<Auth>> findAll(){
        return ResponseEntity.ok(authService.findAll());
    }*/

    //Tokenli
    @GetMapping(GETALL)
    public ResponseEntity<List<Auth>> findAll(String token){
        return ResponseEntity.ok(authService.findAll(token));
    }


    @GetMapping("/hi")
    public String hello(){return "Hi API";}

}
