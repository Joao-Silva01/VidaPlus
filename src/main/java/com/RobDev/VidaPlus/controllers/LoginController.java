package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.login.LoginRequest;
import com.RobDev.VidaPlus.dto.login.LoginResponse;
import com.RobDev.VidaPlus.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private TokenService tokenService;

    @PostMapping
    private ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){

        return ResponseEntity.ok().body(tokenService.login(request));
    }
}
