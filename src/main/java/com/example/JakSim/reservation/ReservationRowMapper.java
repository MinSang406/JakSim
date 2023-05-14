package com.example.JakSim.reservation;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationRowMapper implements RowMapper<ReservationDo> {

    public ReservationDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        ReservationDo reservation = new ReservationDo();

        reservation.setR_idx(rs.getInt("RES_IDX"));
        reservation.setT_idx(rs.getInt("T_IDX"));
        reservation.setUser_id(rs.getString("USER_ID"));
        reservation.setR_c_dt(rs.getString("RES_C_DT"));

        return reservation;
    }

}
