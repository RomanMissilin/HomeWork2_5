package com.example.homework2_5.Controller;

import com.example.homework2_5.Exception.PasswordRestrictionsException;
import com.example.homework2_5.Exception.WrongLoginException;
import com.example.homework2_5.Exception.WrongPasswordException;
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
    public String stringLogin(@RequestParam("login") String login,
                              @RequestParam("password") String password,
                              @RequestParam("confirmPassword") String confirmPassword) {
        try {
            return loginOptionsService.stringLogin(login, password, confirmPassword);
        } catch (WrongLoginException q) {
            return "Пароль должен равняться или равняться 20 символам.";
        } catch (WrongPasswordException w) {
            return "Пароль не совпадает!";
        } catch (PasswordRestrictionsException e) {
            return "Нельзя использовать данные символы!";
        }finally {
            System.out.println("Работа метода закончена");
        }
    }
}