package com.example.JakSim.review.model.rowmapper;

import com.example.JakSim.review.model.ReviewDo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReviewRowMapper implements RowMapper<ReviewDo> {
    @Override
    public ReviewDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        ReviewDo review = new ReviewDo();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        review.setIdx(rs.getInt("R_IDX"));
        review.setUser_id(rs.getString("USER_ID"));
        review.setUt_idx(rs.getInt("UT_IDX"));
        review.setContent(rs.getString("R_CONTENT"));
        review.setStar(rs.getInt("R_STAR"));
        review.setCreateDate(LocalDateTime.parse(rs.getString("R_C_DT"), formatter));
        if(rs.getString("R_M_DT") != null)
            review.setModifiedDate(LocalDateTime.parse(rs.getString("R_M_DT"), formatter));

        return review;
    }
}
