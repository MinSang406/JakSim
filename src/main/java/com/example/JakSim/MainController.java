package com.example.JakSim;

import com.example.JakSim.login.model.RegisterService;
import com.example.JakSim.login.model.UserInfo;
import com.example.JakSim.trainer.model.TrainerDao;
import com.example.JakSim.trainer.model.TrainerListService;
import com.example.JakSim.trainer.model.TrainerService;
import com.example.JakSim.trainer.model.Wrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final TrainerListService trainerListService;
    @GetMapping("/")
    public String index(@AuthenticationPrincipal User info, Model model) throws SQLException {
        model.addAttribute("trainerList", trainerListService.getAllTrainers());

        return "content/index";
    }
}
