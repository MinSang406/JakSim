package com.example.JakSim.reservation;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private DataSource ds;
    private ReservationDao reservationDao;
//    private UserDao userDao;
    public List<Reservation> searchAllReservation(String userId) {
        System.out.println("service ::: " + userId);

//        try {
//            // null인지 먼저 판별해줘야 함.
//            // userDao.findById(userId); _조장님이 하고 있음.
//        } catch (NullPointerException e) {
//            System.out.println("--NullPointerException 발생--");
//            System.out.println("현재 유저는 등록되어 있지 않은 회원입니다.");
//            return null; // 이것도 맞는지 판별
//        }
        List<Reservation> r = reservationDao.findAllByUserId(userId);
        return r;
//        return null;
    }

}
