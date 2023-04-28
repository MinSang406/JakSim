package com.example.JakSim.Account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
    @GetMapping("/signup")
    public String Signup(){
        return "content/account/register";

        //in the fork
    }
}
