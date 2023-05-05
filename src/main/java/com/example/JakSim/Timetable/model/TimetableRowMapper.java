package com.example.JakSim.Timetable.model;

import com.example.JakSim.Timetable.dto.TimetableRequest;

public class TimetableRowMapper {
    TimetableRequest timetable = new TimetableRequest();

        timetable.setUser_id(rs.getString("USER_ID"));
        timetable.setUser_name(rs.getString("USER_NAME"));
        timetable.setUser_gender(rs.getInt("USER_GENDER"));
        timetable.setUser_tel(rs.getString("USER_TEL"));
        timetable.setUser_pw(rs.getString("USER_PW"));
        timetable.setUser_question(rs.getInt("USER_QUESTION"));
        timetable.setUser_answer(rs.getString("USER_ANSWER"));
        timetable.setUser_type(rs.getInt("USER_TYPE"));
        timetable.setUser_birth(rs.getString("USER_BIRTH"));
        timetable.setUser_c_dt(rs.getString("USER_C_DT"));

        return timetable;
}
