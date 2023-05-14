package com.example.JakSim.login.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
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
    private int user_pt;


}
