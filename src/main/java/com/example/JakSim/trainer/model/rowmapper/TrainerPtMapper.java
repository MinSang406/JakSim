package com.example.JakSim.trainer.model.rowmapper;

import com.example.JakSim.trainer.model.TrainerPtDo;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TrainerPtMapper implements RowMapper<TrainerPtDo> {
    @Override
    public TrainerPtDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        TrainerPtDo pt = new TrainerPtDo();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        pt.setIdx(rs.getInt("TP_IDX"));
        pt.setUt_idx(rs.getInt("UT_IDX"));
        pt.setTimes(rs.getInt("TP_TIMES"));
        pt.setMonth(rs.getInt("TP_MONTH"));
        pt.setPrice(rs.getInt("TP_PRICE"));
        pt.setType(rs.getInt("TP_TYPE"));

        pt.setCreateDate(LocalDateTime.parse(rs.getString("TP_C_DT"), formatter));

        return pt;
    }
}
