package com.example.JakSim.reservation;

import com.example.JakSim.trainer.model.TrainerDao;
import com.example.JakSim.trainer.model.TrainerDo;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private DataSource ds;


    //    private UserDao userDao;
    private ReservationDao reservationDao;

    public List<ReservationUser> searchAllReservation(String userId) {
        int i = 0;
        reservationDao = new ReservationDao(ds);
        List<ReservationUser> reservationUser = new ArrayList<>();

        try {
            // null인지 먼저 판별해줘야 함.
            // userDao.findById(userId); _조장님이 하고 있음.
        } catch (NullPointerException e) {
            System.out.println("현재 유저는 등록되어 있지 않은 회원입니다.");
            return null;
        }

        reservationUser = reservationDao.findAllByUserId(userId);

        for (ReservationUser r: reservationUser) {
            // 3. Reservation의 예약 현황이 취소가 아닌 것 빼고 다 불러오기
            if(r.getR_result() == 1) {
                // 예약 취소인 것
                reservationUser.remove(i);
            }
            // 예약 완료 & 예약 대기는 패쓰~~

            i++;
        }

        return reservationUser;
    }

}
