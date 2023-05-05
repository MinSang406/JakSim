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
        LoginDao loginDao = new LoginDao(ds);
        return loginDao.findById(user_id);
    }

    public void updatePassword(String findId, String findPw) {
        LoginDao loginDao = new LoginDao(ds);
        loginDao.updatePassword(findId, findPw);
    }
}
