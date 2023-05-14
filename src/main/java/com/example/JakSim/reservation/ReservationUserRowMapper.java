package com.example.JakSim.reservation;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationUserRowMapper implements RowMapper<ReservationUser> {

    public ReservationUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        ReservationUser reservationUser = new ReservationUser();

        reservationUser.setRes_idx(rs.getInt("RES_IDX"));
        reservationUser.setT_idx(rs.getInt("T_IDX"));
        reservationUser.setUser_id(rs.getString("USER_ID"));
        reservationUser.setRes_c_dt(rs.getString("RES_C_DT"));
        reservationUser.setUt_idx(rs.getInt("UT_IDX"));
        reservationUser.setT_start_t(rs.getString("T_START_T"));
        reservationUser.setT_end_t(rs.getString("T_END_T"));
        reservationUser.setT_max(rs.getInt("T_MAX"));
        reservationUser.setT_cur(rs.getInt("T_CUR"));
        reservationUser.setT_type(rs.getInt("T_TYPE"));

        return reservationUser;
    }
}
