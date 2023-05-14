package com.example.JakSim.login.model;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class LoginService {
    @Autowired
    private DataSource ds;

    private final PasswordEncoder passwordEncoder;

    public void registerUser(UserInfo user){
        UserDao userDao = new UserDao(ds);
        user.setUser_pw(passwordEncoder.encode(user.getUser_pw()));
        userDao.insertTest(user);
    }

    public UserInfo findUserTel(String tel) throws SQLException {
        UserDao userDao = new UserDao(ds);
        return userDao.findByTel(tel);
    }
}
