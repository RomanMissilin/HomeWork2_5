package com.example.homework2_5.Controller;

import com.example.homework2_5.Service.LoginOptionsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginOptionsController {

    private final LoginOptionsService loginOptionsService;

    public LoginOptionsController(LoginOptionsService loginOptionsService) {
        this.loginOptionsService = loginOptionsService;
    }

    @GetMapping(path = "/LoginOptions/Login")
    public String stringLogin(@RequestParam("Login") String Login,
                              @RequestParam("password") String password,
                              @RequestParam("confirmPassword") String confirmPassword) {
        return loginOptionsService.stringLogin(Login, password, confirmPassword);
    }
}