package com.example.JakSim.trainer.model.rowmapper;

import com.example.JakSim.trainer.model.TrainerExpertDo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerExpertMapper implements RowMapper<TrainerExpertDo> {
    @Override
    public TrainerExpertDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        TrainerExpertDo expert = new TrainerExpertDo();

        expert.setIdx(rs.getInt("TE_IDX"));
        expert.setUt_idx(rs.getInt("UT_IDX"));
        expert.setExpert(rs.getInt("TE_EXPERT"));

        return expert;
    }
}
