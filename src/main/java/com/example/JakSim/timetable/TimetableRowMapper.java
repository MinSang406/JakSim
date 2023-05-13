package com.example.JakSim.timetable;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TimetableRowMapper implements RowMapper<TimetableDo> {

    public TimetableDo mapRow(ResultSet rs, int fowNum) throws SQLException {
        TimetableDo timetable = new TimetableDo();

        timetable.setT_idx(rs.getInt("T_IDX"));
        timetable.setUt_idx(rs.getInt("UT_IDX"));
        timetable.setT_start_t(rs.getString("T_START_T"));
        timetable.setT_end_t(rs.getString("T_END_T"));
        timetable.setT_people(rs.getInt("T_PEOPLE"));
        timetable.setT_type(rs.getInt("T_TYPE"));

        return timetable;
    }

}
