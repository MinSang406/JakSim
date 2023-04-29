package com.example.JakSim.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

import javax.sql.DataSource;
import java.sql.*;

public class JDBCTest {
    @Autowired
    private DataSource ds;

    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private String sql;

    public JDBCTest(){

    }

    public void findById() throws SQLException{
        this.sql = "select * from user_info where user_id = ?";

        Connection conn = ds.getConnection();
        this.pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "hye8997");

        this.rs = pstmt.executeQuery();

        if(rs.next()){
            System.out.println(rs.getString("USER_NAME"));
            System.out.println(rs.getString("USER_PW"));
            System.out.println(rs.getString("USER_C_DT"));
            try {
                if (!conn.isClosed())
                    conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
