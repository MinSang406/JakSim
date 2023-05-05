package com.example.JakSim.trainer.controller;

import com.example.JakSim.trainer.model.TrainerDo;
import com.example.JakSim.trainer.model.TrainerRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
@RequiredArgsConstructor
public class TrainerControllerTest {
    private final TrainerRegisterService trainerRegisterService;
    @GetMapping("trainer/register/test")
    public String create() {
        return "content/trainer/trainerRegisterTest";
    }

    @PostMapping("trainer/regist/action")
    public String createTest(TrainerDo trainerDo) throws SQLException {

        trainerRegisterService.RegistTest(trainerDo);
        return "redirect:/";
    }

}
