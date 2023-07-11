package com.huythanh0x.springudemycouponserver.controller;

import com.huythanh0x.springudemycouponserver.dto.AuthResponseDTO;
import com.huythanh0x.springudemycouponserver.dto.LoginDTO;
import com.huythanh0x.springudemycouponserver.dto.RegisterDTO;
import com.huythanh0x.springudemycouponserver.service.AuthService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@ComponentScan("com.huythanh0x.springudemycouponserver.security")
public class AuthController {
    AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDto) {
        authService.validateLoginData(loginDto.getUsername(), loginDto.getPassword());
        String tokenForUser = authService.getJwtTokenForCurrentUser(loginDto.getUsername(), loginDto.getPassword());
        return new ResponseEntity<>(new AuthResponseDTO(tokenForUser), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDto) {
        authService.validateRegisterData(registerDto.getUsername(), registerDto.getPassword());
        authService.checkIfUserExist(registerDto.getUsername());
        authService.createUserWith(registerDto.getUsername(), registerDto.getPassword());
        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}