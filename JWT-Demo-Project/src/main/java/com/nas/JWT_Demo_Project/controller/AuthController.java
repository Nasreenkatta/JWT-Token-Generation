package com.nas.JWT_Demo_Project.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nas.JWT_Demo_Project.model.AuthRequest;
import com.nas.JWT_Demo_Project.service.JwtService;
@RestController
public class AuthController {
	private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest request) {
        if ("john".equals(request.getUsername()) && "12345".equals(request.getPassword())) {
            String token = jwtService.generateToken(request.getUsername());
            return Map.of("token", token);
        }
        throw new RuntimeException("Invalid credentials");
    }


    @GetMapping("/hello")
    public String hello() {
        return "Hello, authenticated user!";
    }
}
