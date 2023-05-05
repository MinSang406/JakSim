package com.example.JakSim.Timetable.model;

import com.example.JakSim.Timetable.domain.Timetable;
import com.example.JakSim.Timetable.dto.TimetableRequest;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class TimetableDao {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public TimetableDao(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public TimetableRequest findTimetableByUtIdx(String id) throws SQLException {
        this.sql = "select * from Timetable";

        TimetableRequest timetable = null;
//        String userId = "hye8997";

        try {
            timetable = jdbcTemplate.queryForObject(this.sql, new TimetableRowMapper(), id);
        } catch(EmptyResultDataAccessException e){
            e.printStackTrace();
        }

        System.out.println(timetable.toString());

        return timetable;
    }
}