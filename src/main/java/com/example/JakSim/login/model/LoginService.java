package com.example.JakSim.login.model;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private DataSource ds;

    public void registerUser(UserInfo user){
        LoginDao loginDao = new LoginDao(ds);
        loginDao.insertTest(user);
    }
}
