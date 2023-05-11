package com.example.JakSim.timetable;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class TimetableDao {
    private JdbcTemplate jdbcTemplate;
    private String sql;
    private Timetable timetable;

    public TimetableDao(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }
}
