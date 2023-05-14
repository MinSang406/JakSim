package com.example.JakSim.login.model;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RegisterService {
    @Autowired
    private DataSource ds;

    public UserInfo findByUserId(String user_id) throws SQLException {
        UserDao userDao = new UserDao(ds);
        return userDao.findById(user_id);
    }

    public void updatePassword(String findId, String findPw) {
        UserDao userDao = new UserDao(ds);
        userDao.updatePassword(findId, findPw);
    }
}
