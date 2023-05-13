package com.example.JakSim.timetable;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TimetableDao {
    private JdbcTemplate jdbcTemplate;
    private String sql;
    private TimetableDo timetable;

    public TimetableDao(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public List<TimetableDo> searchAllTimetable(String userId) {

    return null;
    }

    public Boolean deleteUserTimetable(int tIdx) {
        this.sql = "delete from timetable" +
                    "where t_idx = ?";

        try {
            jdbcTemplate.update(this.sql, tIdx);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("예약 취소(시간표)가 올바르게 되지 않았습니다.");
            return false;
        }

        System.out.println("예약 취소(시간표) 완료!!");
        return true;
    }
}
