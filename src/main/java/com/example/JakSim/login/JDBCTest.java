package com.example.JakSim.login;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;

public class JDBCTest {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public JDBCTest(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public void findById() throws SQLException{
        this.sql = "select * from user_info where user_id = ?";

        UserInfo userInfo = null;
        String userId = "hye8997";

        try{
            userInfo = jdbcTemplate.queryForObject(this.sql, new UserRowMapper(), userId);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
        }

        System.out.println(userInfo.toString());
    }
}
