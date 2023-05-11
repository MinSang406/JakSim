package com.example.JakSim.reservation;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationRowMapper implements RowMapper<Reservation> {

    public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Reservation reservation = new Reservation();

        reservation.setR_idx(rs.getInt("RES_IDX"));
        reservation.setT_idx(rs.getInt("T_IDX"));
        reservation.setTp_idx(rs.getInt("TP_IDX"));
        reservation.setUser_id(rs.getString("USER_ID"));
        reservation.setR_c_dt(rs.getString("RES_C_DT"));
        reservation.setR_result(rs.getInt("RES_RESULT"));

        return reservation;
    }

}
