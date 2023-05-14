package com.example.JakSim.reservation;

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
        
        return reservationUser;
    }


    public Boolean reservationAvailable(String userId, String date) {

        return reservationDao.available(userId, date);
    }


    public Boolean register(String userId, String date) {
        TimetableDo timetableDo = reservationDao.findAllByDate(date);
        int tIdx = timetableDo.getT_idx();

        //////////////////////////////
//        public void decreaseCnt(String userId) {
//            this.sql = "update timetable " +
//                    "set user_pt = user_pt - 1" +
//                    "where user_id = ?";
//
//            try {
//                jdbcTemplate.update(this.sql, userId);
//            } catch (EmptyResultDataAccessException e) {
//                System.out.println("사용자 pt횟수 변경이 올바르게 되지 않았습니다.");
//                return;
//            }
//
//            System.out.println("사용자 pt횟수 변경 완료!!");
//            return;
//        }

        //////////////////////////////

        //////////////////////////////
//        public int findByUser(String userId) {
//            this.sql = "select * from user_info  where user_id = ?";
//
//            return jdbcTemplate.update(this.sql, new UserRowMapper(), userId);
//        }

        //////////////////////////////

        if((userDao.findByUser.getUserPt(userId) > 0) && (timetableDo.getT_cur() < timetableDo.getT_max())) {
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
        TimetableDo timetableDo = reservationDao.findAllByDate(date);
        int tIdx = timetableDo.getT_idx();

        //////////////////////////////
//        public void increaseCnt(String userId) {
//            this.sql = "update timetable " +
//                    "set user_pt = user_pt + 1" +
//                    "where user_id = ?";
//
//            try {
//                jdbcTemplate.update(this.sql, userId);
//            } catch (EmptyResultDataAccessException e) {
//                System.out.println("사용자 pt횟수 변경이 올바르게 되지 않았습니다.");
//                return;
//            }
//
//            System.out.println("사용자 pt횟수 변경 완료!!");
//            return;
//        }

        //////////////////////////////

        if(reservationDao.delete(userId, tIdx)) {
            userDao.increaseCnt(userId);
            timetableDao.decreaseCurr(tIdx);
            return true;
        }

        return false;
    }

}
