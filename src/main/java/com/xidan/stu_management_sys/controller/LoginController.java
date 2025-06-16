package com.xidan.stu_management_sys.controller;

import com.xidan.stu_management_sys.Pojo.LoginRequest;
import com.xidan.stu_management_sys.Pojo.RegisterRequest;
import com.xidan.stu_management_sys.Pojo.Result;
import com.xidan.stu_management_sys.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }


    @PostMapping("/register")
    public Result register(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }


}
