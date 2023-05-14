package com.example.JakSim.pay;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PayMentRowMapper implements RowMapper<PayMentDo> {

    public PayMentDo mapRow(ResultSet rs, int nowNum) throws SQLException {
        PayMentDo payment = new PayMentDo();

        payment.setP_idx(rs.getInt("P_IDX"));
        payment.setUser_id(rs.getString("USER_ID"));
        payment.setTp_idx(rs.getInt("TP_IDX"));
        payment.setP_refound(rs.getInt("P_REFOUND"));
        payment.setValidate(rs.getInt("P_VALIDATE"));
        payment.setP_c_dt(rs.getString("P_C_DT"));
        payment.setP_m_dt(rs.getString("P_M_DT"));

        return payment;
    }
}
