package com.example.JakSim.timetable;

import com.example.JakSim.reservation.ReservationDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {
    @Autowired
    private DataSource ds;
    private  TimetableDao timetableDao;



    public List<Timetable> searchAllTimetable(String userId) {
        // 1. user가 존재하는 유저인지 확인
         try {
            // null인지 먼저 판별해줘야 함.
            // userDao.findById(userId); _조장님이 하고 있음.
        } catch (NullPointerException e) {
            System.out.println("현재 유저는 등록되어 있지 않은 회원입니다.");
            return null;
        }
        // 2. 유저가 결제를 찾아 환불이 안됐고 아직 횟수가 남은 피티가 있는지 확인
        // tpIdx = payDao.findTpById(userId);

        // 3. 해당 결제에서 pt정보 테이블을 불러오고 그 pt정보 테이블에서 트레이너 id를 빼와

        // 4. 해당 트레이너의 모든 시간표 조회
        timetableDao.searchAllTimetable(userId);

        return null; // 변경 필요
    }

}
