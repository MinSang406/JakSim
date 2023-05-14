package com.example.JakSim.pay;

import com.example.JakSim.reservation.ReservationRowMapper;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class PayMentDao {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public PayMentDao(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public int findtpIdxByuserId(String userId) {
        PayMentDo payMentDo;
        int tpIdx;
        this.sql = "select tp_idx from payment where user_id = ?";

        try {
            payMentDo = jdbcTemplate.queryForObject(this.sql, new PayMentRowMapper(), userId);
            tpIdx = payMentDo.getTp_idx();

        } catch (EmptyResultDataAccessException e) {
            System.out.println("예약이 올바르게 되지 않았습니다.");
            return -1;
        }

        return tpIdx;
    }
}
