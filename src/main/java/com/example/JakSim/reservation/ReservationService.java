package com.example.JakSim.reservation;

import com.example.JakSim.login.model.UserDao;
import com.example.JakSim.login.model.UserInfo;
import com.example.JakSim.pay.PayMentDao;
import com.example.JakSim.timetable.TimetableDao;
import com.example.JakSim.timetable.TimetableDo;
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
    private TimetableDao timetableDao;
    private PayMentDao payDao;
    private UserDao userDao;

    public List<ReservationUser> searchAllReservation(String userId) {
        int i = 0;
        reservationDao = new ReservationDao(ds);
        List<ReservationUser> reservationUser = new ArrayList<>();

        try {
            reservationUser = reservationDao.findAllByUserId(userId);
        } catch (Exception e) {
            return null;
        }
        System.out.println("DAODAO::::" + reservationUser);
        return reservationUser;
    }


    public Boolean reservationAvailable(String userId, String date) {

        return reservationDao.available(userId, date);
    }


    public Boolean register(String userId, String date) {

        timetableDao = new TimetableDao(ds);
        TimetableDo timetableDo = timetableDao.findByDate(date);

        if(timetableDo == null) {
            System.out.println("null이당!!!!");
            return false;
        }
        int tIdx = timetableDo.getT_idx();

        UserInfo userInfo = null;
        try {
            userInfo = userDao.findById(userId);
        } catch(Exception e) {
            System.out.println("조회되지 않은 닉네임");
            return false;
        }

        if((userInfo.getUser_pt() > 0) && (timetableDo.getT_cur() < timetableDo.getT_max())) {
            System.out.println("if문 들어옴" + "예약 가능status");
            try{
                reservationDao.insert(tIdx, userId, date);
            } catch(Exception e) {
                return false;
            }

            userDao.decreaseCnt(userId);
            timetableDao.increaseCurr(tIdx);
            return true;
        }

        return false;
    }

    public Boolean delete(String userId, String date) {
        timetableDao = new TimetableDao(ds);
        reservationDao = new ReservationDao(ds);

        TimetableDo timetableDo = timetableDao.findByDate(date);
        if(timetableDo == null) {
            System.out.println("null이당!!!!");
            return false;
        }
        System.out.println(timetableDo.toString());

        int tIdx = timetableDo.getT_idx();

        if(reservationDao.delete(userId, tIdx)) {
            userDao.increaseCnt(userId);
            timetableDao.decreaseCurr(tIdx);
            return true;
        }

        return false;
    }
}
