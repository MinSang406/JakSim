package com.example.JakSim.trainer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainerController {
    @GetMapping("trainer/register")
    public String create() {
        return "content/account/trainerRegister";
    }
    @GetMapping("trainer/function")
    public String function(){
        return "content/accout/fuctiontest";
    }
}
