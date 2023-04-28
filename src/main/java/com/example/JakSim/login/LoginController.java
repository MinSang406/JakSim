package com.example.JakSim.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){

        return "content/account/login";
        //민상 왔다감ㅋ
    }
}

