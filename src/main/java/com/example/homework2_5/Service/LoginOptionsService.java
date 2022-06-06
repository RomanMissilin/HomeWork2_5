package com.example.homework2_5.Service;

import com.example.homework2_5.Exception.WrongLoginException;
import com.example.homework2_5.Exception.WrongPasswordException;
import org.springframework.stereotype.Service;

@Service
public class LoginOptionsService {

    private static String validCharPassword = "1234567890qwertyuiopasdfghjklzxcvbnm_*";
    private static String validCharLogin = "1234567890qwertyuiopasdfghjklzxcvbnm_*.";

    public String stringLogin(String login, String password, String confirmPassword) {
        if (password.length() >= 20) {
            throw new WrongLoginException();
        }
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException();
        }
        if (login.length() > 20) {
            throw new WrongPasswordException();
        }
        for (char s: password.toCharArray()) {
            if (!validCharPassword.contains(String.valueOf(s))) {
                throw new WrongPasswordException();
            }
            for (char a : login.toCharArray()) {
                if (!validCharLogin.contains(String.valueOf(a))) {
                    throw new WrongLoginException();
                }
            }
        }
        return String.valueOf(true);
    }
}