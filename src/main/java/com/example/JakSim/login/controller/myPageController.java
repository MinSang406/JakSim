package com.example.JakSim.login.controller;

import com.example.JakSim.login.model.UserInfo;
import com.example.JakSim.login.model.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;


@Controller
@SessionAttributes("user")
@RequiredArgsConstructor
public class myPageController {
    @Autowired
    private DataSource ds;
    private final UserService userService;

    @GetMapping("/myPage")
    public String showMyUserInfo(@AuthenticationPrincipal User info, Model model) throws SQLException {
        //System.out.println(info.getUsername());
        String userId = info.getUsername();
        UserInfo userInfo = userService.searchUser(userId);

        if(info != null) {
            System.out.println(userService.searchUser(info.getUsername()).toString());
            model.addAttribute("userinfo", userInfo);
        }
        return "content/account/myPage";
    }

    @PostMapping("/update-userInfo")
    public String updateUserInfo(@AuthenticationPrincipal User info,
                                 @ModelAttribute("user_tel") String user_tel,
                                 @ModelAttribute("user_birth") String user_birth,
                                 @ModelAttribute("user_question") String user_question,
                                 @ModelAttribute("user_answer") String user_answer,
                                 Model model) throws SQLException {
        try {
            String userId = info.getUsername();
            UserInfo userInfo = userService.searchUser(userId);
            model.addAttribute("userinfo", userInfo);
            int u_question = 0;

            if(user_question.equals("0")) {
                u_question = 0;
            }
            else if(user_question.equals("1")) {
                u_question = 1;
            }
            else if(user_question.equals("2")) {
                u_question = 2;
            }
            else if(user_question.equals("3")) {
                u_question = 3;
            }else if(user_question.equals("4")) {
                u_question = 4;
            }

            userService.updateUser(userId, user_tel, u_question, user_answer);
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/";
        }
    }

    @PostMapping("/delete-userInfo")
    public String deleteUserInfo(@AuthenticationPrincipal User info) throws SQLException {
        String userId = info.getUsername();
        userService.deleteUser(userId);
        return "redirect:/logout";
    }

}

