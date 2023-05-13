package com.example.JakSim.reservation;

import com.example.JakSim.login.model.UserInfo;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class ReservationDao {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public ReservationDao(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public List<ReservationUser> findAllByUserId(String userId) {
        List<ReservationUser> reservationUser = new ArrayList<>();

        this.sql = "select * from reservation";

        try {
            // 1. Reservation테이블에서 userId로 해당 유저에 해당하는 예약이 있는지 보기
            jdbcTemplate.query(this.sql, new ReservationRowMapper());
        } catch (EmptyResultDataAccessException e) {
            System.out.println("예약이 존재하지 않습니다.");
            return null;
        }

        // 1. Reservation테이블에서 userId로 해당 유저에 해당하는 예약을 모두 찾아준다
        // 2. Reservation의 IDX(R_IDX)로 Timetable의 정보를 join시켜서 테이블 가져오기
        this.sql = "select * from reservation natural join timetable where user_id = ?";
        reservationUser = jdbcTemplate.query(this.sql, new ReservationUserRowMapper(), userId);

        return reservationUser;
    }

    public Boolean insert(String userId, int tIdx, String date, int tpIdx) {
        this.sql = "insert into reservation" +
                    "values(RESERVATION_SEQ.NEXTVAL, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";

        try {
            jdbcTemplate.update(this.sql, tIdx, userId, tpIdx, date);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("예약이 올바르게 되지 않았습니다.");
            return false;
        }

        System.out.println("예약 완료!!");
        return true;
    }
}
