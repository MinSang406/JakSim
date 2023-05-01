package com.example.JakSim.login.model;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;

public class LoginDao {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public LoginDao(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public UserInfo findById() throws SQLException{
        this.sql = "select * from user_info where user_id = ?";

        UserInfo userInfo = null;
        String userId = "hye8997";

        try{
            userInfo = jdbcTemplate.queryForObject(this.sql, new UserRowMapper(), userId);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
        }

        System.out.println(userInfo.toString());
        return userInfo;
    }

    public void insertTest(UserInfo user){
        this.sql =  "insert into user_info(user_id, user_name, user_gender, user_tel, user_pw, user_question, user_answer, user_type, user_birth, user_c_dt)" +
                "values(?, ?, ?, ?, ?, ?, ? ,?, to_date(?, 'yyyy/mm/dd'), sysdate)";
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new UserRegisterPreparedStatementCreator(user, sql), keyHolder);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
        }
        System.out.println("Success");
    }
}
