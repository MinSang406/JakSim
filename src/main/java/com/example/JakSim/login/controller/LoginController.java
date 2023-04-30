package com.example.JakSim.login.controller;

import com.example.JakSim.login.model.LoginDao;
import com.example.JakSim.login.model.UserInfo;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;


@Controller
public class LoginController {
    @Autowired
    private DataSource ds;

    @GetMapping("/login")
    public String login(){

        return "content/account/login";
    }

    @GetMapping("/test")
    public String tester(Model model) throws SQLException {
        LoginDao dao = new LoginDao(ds);
        model.addAttribute("userinfo", dao.findById());
        return "content/test/test";
    }

    @PostMapping("/login")
    public void postLogin(UserInfo param){
    }
}

