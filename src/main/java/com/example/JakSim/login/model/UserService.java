package com.example.JakSim.login.model;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class UserService {
    @Autowired
    private DataSource ds;

    public void registerUser(UserInfo user){
        UserDao UserDao = new UserDao(ds);
        UserDao.insertTest(user);
    }

    @Transactional
    public void updateUser(String userId, String user_tel ,int user_question, String user_answer){
        UserDao UserDao = new UserDao(ds);

        try {
            UserDao.updateUser(userId, user_tel, user_question, user_answer);
            System.out.println("수정성공");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Transactional
    public void deleteUser(String userId) {
        UserDao UserDao = new UserDao(ds);
        try {
            UserDao.deleteUserId(userId);
            System.out.println("탈퇴 성공인듯");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserInfo searchUser(String userId) throws SQLException {
        UserDao UserDao = new UserDao(ds);
        UserInfo userInfo = new UserInfo();
        userInfo = UserDao.findById(userId);

        return userInfo;
    }
}
