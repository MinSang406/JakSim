package com.example.JakSim.login.controller;

import com.example.JakSim.login.model.LoginService;
import com.example.JakSim.login.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;


@Controller
@RequiredArgsConstructor
public class LoginController {
    @Autowired
    private DataSource ds;
    private final LoginService loginService;

    @GetMapping("/login")
    public String login(){

        return "content/account/login";
    }

    @GetMapping("/find")
    public String find(){
        return "content/account/find";
    }

    @PostMapping("/find/tel/{tel}")
    @ResponseBody
    public UserInfo findByTel(@PathVariable("tel") String tel) throws SQLException {
        return loginService.findUserTel(tel);
    }


}

