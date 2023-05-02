package com.example.JakSim.login.controller;

import com.example.JakSim.login.model.LoginDao;
import com.example.JakSim.login.model.LoginService;
import com.example.JakSim.login.model.RegisterService;
import com.example.JakSim.login.model.UserInfo;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final LoginService loginService;
    private final RegisterService registerService;
    @GetMapping("/register")
    public String register(){
        return "content/account/register";
    }

    @PostMapping("/register/action")
    public String registerUser(UserInfo param){
        System.out.println(param.getUser_birth());
        loginService.registerUser(param);
        return "redirect:/";
    }
    @PostMapping("/register/check/{user_id}")
    @ResponseBody
    public String registerCheck(@PathVariable("user_id") String user_id) throws SQLException {
        UserInfo userInfo = registerService.findByUserId(user_id);
        if(userInfo == null)
            return "";
        return "duplicated";
    }
}
