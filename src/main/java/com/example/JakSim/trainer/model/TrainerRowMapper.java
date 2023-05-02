package com.example.JakSim.trainer.model;

import com.example.JakSim.login.model.UserInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerRowMapper implements RowMapper<UserInfo> {
    @Override
    public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        TrainerDo trainerDo = new TrainerDo();

        trainerDo.setUser_id(rs.getString("USER_ID"));
        trainerDo.setUser_name(rs.getString("USER_NAME"));
        trainerDo.setUser_gender(rs.getInt("USER_GENDER"));
        trainerDo.setUser_tel(rs.getString("USER_TEL"));
        trainerDo.setUser_pw(rs.getString("USER_PW"));
        trainerDo.setUser_question(rs.getInt("USER_QUESTION"));
        trainerDo.setUser_answer(rs.getString("USER_ANSWER"));
        trainerDo.setUser_type(rs.getInt("USER_TYPE"));
        trainerDo.setUser_birth(rs.getString("USER_BIRTH"));
        trainerDo.setUser_c_dt(rs.getString("USER_C_DT"));

        return trainerDo;
    }
}