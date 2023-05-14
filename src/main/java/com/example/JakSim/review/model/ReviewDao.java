package com.example.JakSim.review.model;

import com.example.JakSim.review.model.rowmapper.ReviewImageMapper;
import com.example.JakSim.review.model.rowmapper.ReviewRowMapper;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class ReviewDao {

    private JdbcTemplate jdbcTemplate;
    private String sql;
    public ReviewDao(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public List<ReviewDo> getAllReview(){
        List<ReviewDo> reviewList = new ArrayList<>();

        this.sql = "select * from review order by r_c_dt desc";

        try{
            reviewList = jdbcTemplate.query(this.sql, new ReviewRowMapper());
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
        }

        return reviewList;
    }

    public List<ReviewDo> getReview(int utIdx){
        List<ReviewDo> reviewList = new ArrayList<>();

        this.sql = "select * from review where ut_idx = ? order by r_c_dt desc";

        try{
            reviewList = jdbcTemplate.query(this.sql, new ReviewRowMapper(), utIdx);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
        }

        return reviewList;
    }

    public ReviewDo getMyReview(String userId){
        ReviewDo myReview = new ReviewDo();

        this.sql = "select * from review where user_id = ?";

        try{
            myReview = jdbcTemplate.queryForObject(this.sql, new ReviewRowMapper(), userId);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
        }

        return myReview;
    }

    public List<ReviewImageDo> getReviewImage(int rIdx){
        List<ReviewImageDo> imageList = new ArrayList<>();
        this.sql = "select * from review_image where r_idx = ?";
        try{
            imageList = jdbcTemplate.query(this.sql, new ReviewImageMapper(), rIdx);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
        }

        return imageList;
    }

    public void deleteReview(String userId){
        this.sql = "DELETE FROM review WHERE user_id = ?";
        try{
            jdbcTemplate.update(this.sql, userId);
        }catch (DataAccessException e){
            e.printStackTrace();
        }
    }

    public void editReview(String reviewId, String newContent, int newRating) {
        this.sql = "UPDATE REVIEW " +
                "SET R_CONTENT = ?, " +
                "R_STAR = ?, " +
                "R_M_DT = SYSDATE " +
                "WHERE USER_ID = ?";

        try {
            int affectedRows = jdbcTemplate.update(this.sql, newContent, newRating, reviewId);
            if (affectedRows > 0) {
                System.out.println("수정성공!");
            } else {
                System.out.println("수정실패!");
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
