package com.example.JakSim.trainer.model.rowmapper;

import com.example.JakSim.review.model.ReviewDo;
import com.example.JakSim.trainer.model.TrainerImageDo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerImageMapper implements RowMapper<TrainerImageDo> {
    @Override
    public TrainerImageDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        TrainerImageDo image = new TrainerImageDo();

        image.setIdx(rs.getInt("TI_IDX"));
        image.setUt_idx(rs.getInt("UT_IDX"));
        image.setPath(rs.getString("TI_PATH"));

        return image;
    }
}
