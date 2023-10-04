package com.aminenurgynk.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/auth")
    public ResponseEntity<String> hello(){return ResponseEntity.ok("Auth service refuses to work.");}
    @GetMapping("/product")
    public ResponseEntity<String> hello1(){return ResponseEntity.ok("Product service refuses to work.");}
    @GetMapping("/sale")
    public ResponseEntity<String> hello2(){return ResponseEntity.ok("Sale service refuses to work.");}
    @GetMapping("/user")
    public ResponseEntity<String> hello3(){return ResponseEntity.ok("User service refuses to work.");}


}
