package com.example.JakSim.trainer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainerController {
    @GetMapping("trainer/register")
    public String create() {
        return "content/trainer/trainerRegister";
    }
}