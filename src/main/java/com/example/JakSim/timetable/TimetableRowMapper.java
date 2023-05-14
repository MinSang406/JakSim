package com.example.JakSim.timetable;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TimetableRowMapper implements RowMapper<TimetableDo> {

    public TimetableDo mapRow(ResultSet rs, int fowNum) throws SQLException {
        TimetableDo timetableDo = new TimetableDo();

        timetableDo.setT_idx(rs.getInt("T_IDX"));
        timetableDo.setUt_idx(rs.getInt("UT_IDX"));
        timetableDo.setT_start_t(rs.getString("T_START_T"));
        timetableDo.setT_end_t(rs.getString("T_END_T"));
        timetableDo.setT_max(rs.getInt("T_MAX"));
        timetableDo.setT_cur(rs.getInt("T_CUR"));
        timetableDo.setT_type(rs.getInt("T_TYPE"));

        return timetableDo;
    }

}
