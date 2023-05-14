package com.example.JakSim.timetable;


import com.example.JakSim.timetable.TimetableDo;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TrainerTimetalbeRegisterPreparedStatementCreator implements PreparedStatementCreator {
    private TimetableDo timetableDo;
    private String[] keyColumns;
    private String sql;

    //private PasswordEncoder passwordEncoder;


    public TrainerTimetalbeRegisterPreparedStatementCreator(TimetableDo timetableDo, String[] keyColumns, String sql){
        this.timetableDo = timetableDo;
        this.keyColumns = keyColumns;
        this.sql = sql;
    }
    public TrainerTimetalbeRegisterPreparedStatementCreator(TimetableDo TimetableDo, String sql){
        this(TimetableDo, new String[] {}, sql);
    }

    @Override
    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement pstmt = null;

        if(keyColumns.length > 0 ){
            pstmt = con.prepareStatement(sql, keyColumns);
        }else{
            pstmt = con.prepareStatement(sql);
        }

        pstmt.setInt(1, timetableDo.getUt_idx());
        pstmt.setString(2, timetableDo.getT_start_t());
        pstmt.setString(3, timetableDo.getT_end_t());
        pstmt.setInt(4, timetableDo.getT_max());
        pstmt.setInt(5, timetableDo.getT_cur());
        pstmt.setInt(6, timetableDo.getT_type());

        return pstmt;
    }
}
