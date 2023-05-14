package com.example.JakSim.timetable;

import com.example.JakSim.reservation.ReservationDao;
import com.example.JakSim.reservation.ReservationDo;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimetableService {
    @Autowired
    private DataSource ds;
    private  TimetableDao timetableDao;
    private ReservationDao reservationDao;


    public List<TimetableDo> registerTimetables(List<TimetableDo> timetableDoList){
        TimetableDao TimetableDao = new TimetableDao(ds);

        for(TimetableDo timetableDO : timetableDoList) {
            timetableDao.insertTimetable(timetableDO);
            System.out.println("insert");
        }

        return timetableDoList;
    }
    public List<TimetableDo> updateTimetables(List<TimetableDo> timetableDoList){
        TimetableDao timetableDao = new TimetableDao(ds);

        for(TimetableDo timetableDO : timetableDoList) {
            timetableDao.updateTimetable(timetableDO);
            System.out.println("update");
        }

        return timetableDoList;
    }
    public List<TimetableDo> searchTimetable(int utIdx) {
        TimetableDao timetableDao = new TimetableDao(ds);
        List<TimetableDo> timeTableList = timetableDao.findAllByUt(utIdx);
        return timeTableList;
    }

    public List<TimetableDo> searchTimetable(String userId, String date) {
        List<TimetableDo> timetableDoList = new ArrayList<>();
        List<TimetableDo> todayTimetableDoList = new ArrayList<>();
        List<ReservationDo> reservationDoList = new ArrayList<>();
        int tpIdx, utIdx;

        reservationDoList = reservationDao.findAllByDate(date);
        if(reservationDoList.isEmpty()) {
            return null;
        }
        // 이게 2번

        tpIdx = timetableDao.findTpByUser(userId);
        if(tpIdx == -1) {
            return null;
        }

        utIdx = timetableDao.findUtByTp(tpIdx);
        if(utIdx == -1) {
            return null;
        }

        timetableDoList = timetableDao.findAllByUt(utIdx);
        // 이까지 1번

        for(TimetableDo timetable : timetableDoList) {
            for(ReservationDo reservation : reservationDoList) {
                if(timetable.getT_idx() == reservation.getT_idx()) {
                    todayTimetableDoList.add(timetable);
                    break;
                }
            }

        }

        return timetableDoList;
    }

}
