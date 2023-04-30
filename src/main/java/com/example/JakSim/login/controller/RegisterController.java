package com.example.JakSim.login.controller;

import com.example.JakSim.login.model.LoginService;
import com.example.JakSim.login.model.UserInfo;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final LoginService loginService;
    @GetMapping("/register")
    public String register(){
        return "content/account/register";
    }

    @PostMapping("/register/action")
    public String registerUser(UserInfo param){
        loginService.registerUser(param);
        return "redirect:/";
    }
}
