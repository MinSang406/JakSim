package com.example.JakSim.review.model.rowmapper;

import com.example.JakSim.review.model.ReviewImageDo;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewImageMapper implements RowMapper<ReviewImageDo> {
    @Override
    public ReviewImageDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        ReviewImageDo image = new ReviewImageDo();

        image.setIdx(rs.getInt("RI_IDX"));
        image.setRIdx(rs.getInt("R_IDX"));
        image.setPath(rs.getString("RI_PATH"));

        return image;
    }
}
