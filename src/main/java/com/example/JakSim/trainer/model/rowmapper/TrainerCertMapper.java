package com.example.JakSim.trainer.model.rowmapper;

import com.example.JakSim.trainer.model.TrainerCertDo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerCertMapper implements RowMapper<TrainerCertDo> {
    @Override
    public TrainerCertDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        TrainerCertDo cert = new TrainerCertDo();

        cert.setIdx(rs.getInt("TC_IDX"));
        cert.setUt_idx(rs.getInt("UT_IDX"));
        cert.setName(rs.getString("TC_NAME"));
        cert.setImage(rs.getString("TC_IMAGE"));

        return cert;
    }
}
