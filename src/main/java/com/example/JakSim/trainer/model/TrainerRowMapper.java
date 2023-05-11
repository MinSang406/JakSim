package com.example.JakSim.trainer.model;

import com.example.JakSim.trainer.model.TrainerDo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerRowMapper implements RowMapper<TrainerDo> {
    @Override
    public TrainerDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        TrainerDo trainerDo = new TrainerDo();

        trainerDo.setId(rs.getInt("UT_IDX"));
        trainerDo.setUserId(rs.getString("USER_ID"));
        trainerDo.setIntroduce(rs.getString("UT_INTRO"));
        trainerDo.setInsta(rs.getString("UT_INSTA"));
        trainerDo.setGym(rs.getString("UT_GYM"));

        return trainerDo;
    }
}