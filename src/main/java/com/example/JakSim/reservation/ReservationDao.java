package com.example.JakSim.reservation;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ReservationDao {
    private JdbcTemplate jdbcTemplate;

    public ReservationDao(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }
    public List<Reservation> findReservationByUserId(String userId) {
        System.out.println(userId);


        return null;
    }


}
