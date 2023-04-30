package com.example.JakSim.login.model;

import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberPreparedStatementCreator implements PreparedStatementCreator {
    private UserInfo userInfo;
    private String[] keyColumns;


    public MemberPreparedStatementCreator(UserInfo userInfo, String[] keyColumns){
        this.userInfo = userInfo;
        this.keyColumns = keyColumns;
    }
    public MemberPreparedStatementCreator(UserInfo userInfo){
        this(userInfo, new String[] {});
    }

    @Override
    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        String sql = "insert into user_info(user_id, user_name, user_gender, user_tel, user_pw, user_question, user_answer, user_type, user_birth, user_c_dt)" +
                "values(?, ?, ?, ?, ?, ?, ? ,?, sysdate, sysdate)";
        PreparedStatement pstmt = null;
        if(keyColumns.length > 0 ){
            pstmt = con.prepareStatement(sql, keyColumns);
        }else{
            pstmt = con.prepareStatement(sql);
        }
        pstmt.setString(1, userInfo.getUser_id());
        pstmt.setString(2, userInfo.getUser_name());
        pstmt.setInt(3, userInfo.getUser_gender());
        pstmt.setString(4, userInfo.getUser_tel());
        pstmt.setString(5, userInfo.getUser_pw());
        pstmt.setInt(6, userInfo.getUser_question());
        pstmt.setString(7, userInfo.getUser_answer());
        pstmt.setInt(8, 1);
        //pstmt.setString(9, userInfo.getUser_birth());

        return pstmt;
    }
}
