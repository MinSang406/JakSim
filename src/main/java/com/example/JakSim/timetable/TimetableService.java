package com.example.JakSim.timetable;

import com.example.JakSim.reservation.ReservationDao;
import com.example.JakSim.reservation.ReservationDo;
import com.example.JakSim.trainer.model.TrainerDao;
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


    public List<TimetableDo> registerTimetables(String user_id, List<TimetableDo> TimetableDoList){
        TimetableDao TimetableDao = new TimetableDao(ds);
        TrainerDao trainerDao = new TrainerDao(ds);

        int ut_idx = trainerDao.getTrainerByUserId(user_id).getId();

        for(TimetableDo TimetableDo : TimetableDoList) {
            TimetableDo.setUt_idx(ut_idx);
            TimetableDao.insertTimetable(TimetableDo);
            System.out.println("insert");
        }

        return TimetableDoList;
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
        reservationDao = new ReservationDao(ds);
        timetableDao = new TimetableDao(ds);

        List<TimetableDo> timetableDoList;
        List<TimetableDo> todayTimetableDoList = new ArrayList<>();
        List<ReservationDo> reservationDoList;
        int tpIdx, utIdx;

        System.out.println("111111111111111111111111");
        reservationDoList = reservationDao.findAllByDate(date);
        if(reservationDoList.isEmpty()) {
            return null;
        }
        // 이게 2번_해당 날짜에 대한 모든 예약
        System.out.println("22222222222222222222");
        tpIdx = timetableDao.findTpByUser(userId);
        if(tpIdx == -1) {
            return null;
        }

        System.out.println("333333333333333333333333");
        utIdx = timetableDao.findUtByTp(tpIdx);
        if(utIdx == -1) {
            return null;
        }

        System.out.println("5444444444444444444444444");
        timetableDoList = timetableDao.findAllByUt(utIdx);
        // 이까지 1번_사용자가 구매한 트레이너의 모든 시간표 불러오기

        for(TimetableDo timetable : timetableDoList) {
            for(ReservationDo reservation : reservationDoList) {
                if(timetable.getT_idx() == reservation.getT_idx()) {
                    todayTimetableDoList.add(timetable);
                    break;
                }
            }

        }

        // 내가 구매한 트레이너에 대한 그날의 모든 시간표
        return timetableDoList;
    }

}
