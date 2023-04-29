package com.example.JakSim.login;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserInfo> {
    @Override
    public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserInfo userInfo = new UserInfo();

        userInfo.setUser_id(rs.getString("USER_ID"));
        userInfo.setUser_name(rs.getString("USER_NAME"));
        userInfo.setUser_gender(rs.getInt("USER_GENDER"));
        userInfo.setUser_tel(rs.getString("USER_TEL"));
        userInfo.setUser_pw(rs.getString("USER_PW"));
        userInfo.setUser_question(rs.getInt("USER_QUESTION"));
        userInfo.setUser_answer(rs.getString("USER_ANSWER"));
        userInfo.setUser_type(rs.getInt("USER_TYPE"));
        userInfo.setUser_birth(rs.getString("USER_BIRTH"));
        userInfo.setUser_c_dt(rs.getString("USER_C_DT"));

        return userInfo;
    }
}
