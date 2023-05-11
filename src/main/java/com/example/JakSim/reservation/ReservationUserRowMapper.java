package com.example.JakSim.reservation;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationUserRowMapper implements RowMapper<ReservationUser> {

    public ReservationUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        ReservationUser reservationUser = new ReservationUser();

        reservationUser.setR_idx(rs.getInt("RES_IDX"));
        reservationUser.setT_idx(rs.getInt("T_IDX"));
        reservationUser.setTp_idx(rs.getInt("TP_IDX"));
        reservationUser.setUser_id(rs.getString("USER_ID"));
        reservationUser.setR_c_dt(rs.getString("RES_C_DT"));
        reservationUser.setR_result(rs.getInt("RES_RESULT"));
        reservationUser.setUt_idx(rs.getInt("UT_IDX"));
        reservationUser.setT_start_t(rs.getString("T_START_T"));
        reservationUser.setT_end_t(rs.getString("T_END_T"));
        reservationUser.setT_people(rs.getInt("T_PEOPLE"));
        reservationUser.setT_type(rs.getInt("T_TYPE"));

        return reservationUser;
    }
}
