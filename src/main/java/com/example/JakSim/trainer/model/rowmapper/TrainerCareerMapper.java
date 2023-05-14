package com.example.JakSim.trainer.model.rowmapper;

import com.example.JakSim.review.model.ReviewDo;
import com.example.JakSim.trainer.model.TrainerCareerDo;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerCareerMapper implements RowMapper<TrainerCareerDo> {
    @Override
    public TrainerCareerDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        TrainerCareerDo career = new TrainerCareerDo();

        career.setIdx(rs.getInt("TCAR_IDX"));
        career.setUt_idx(rs.getInt("UT_IDX"));
        career.setContent(rs.getString("TCAR_CONTENT"));

        return career;
    }
}
