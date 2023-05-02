package com.example.JakSim.login.model;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class UserRegisterPreparedStatementCreator implements PreparedStatementCreator {
    private UserInfo userInfo;
    private String[] keyColumns;
    private String sql;


    public UserRegisterPreparedStatementCreator(UserInfo userInfo, String[] keyColumns, String sql){
        this.userInfo = userInfo;
        this.keyColumns = keyColumns;
        this.sql = sql;
    }
    public UserRegisterPreparedStatementCreator(UserInfo userInfo, String sql){
        this(userInfo, new String[] {}, sql);
    }

    @Override
    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
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
        pstmt.setString(9, userInfo.getUser_birth());

        return pstmt;


    }
}
