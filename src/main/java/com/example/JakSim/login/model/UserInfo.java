package com.example.JakSim.login.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {
    private String user_id;
    private String user_name;
    private int user_gender;
    private String user_tel;
    private String user_pw;
    private int user_question;
    private String user_answer;
    private int user_type;
    private String user_birth;
    private String user_c_dt;

    @Override
    public String toString() {
        return "UserInfo{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_gender=" + user_gender +
                ", user_tel='" + user_tel + '\'' +
                ", user_pw='" + user_pw + '\'' +
                ", user_question=" + user_question +
                ", user_answer='" + user_answer + '\'' +
                ", user_type=" + user_type +
                ", user_birth='" + user_birth + '\'' +
                ", user_c_dt='" + user_c_dt + '\'' +
                '}';
    }
}
