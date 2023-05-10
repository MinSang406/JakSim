package com.example.JakSim.reservation;

import com.example.JakSim.login.model.UserInfo;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class ReservationDao {
    private JdbcTemplate jdbcTemplate;
    private String sql;
    Reservation reservation;

    public ReservationDao(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public List<Reservation> findAllByUserId(String userId) {
        //System.out.println("DAO");
//        int i = 0;
//        List<Reservation> reservation = new ArrayList<>();
//
//        this.sql = "select * from reservation where user_id = ?";
//
//        try {
//            // 1. Reservation테이블에서 userId로 해당 유저에 해당하는 예약이 있는지 보기
//            jdbcTemplate.query(this.sql, new ReservationRowMapper(), userId);
//            System.out.println("try문?");
//        } catch (EmptyResultDataAccessException e) {
//            System.out.println("예약이 존재하지 않습니다.");
////            return null;
//        }
//
//        System.out.println("11111");
//        // 1. Reservation테이블에서 userId로 해당 유저에 해당하는 예약을 모두 찾아준다
//        // 2. Reservation의 IDX(R_IDX)로 Timetable의 정보를 join시켜서 테이블 가져오기
//        this.sql = "select * from reservation r inner join timetable t on r.t_idx = t.t_idx where user_id = ?";
//        reservation = jdbcTemplate.query(this.sql, new ReservationRowMapper(), userId);
//
//        for (Reservation r: reservation) {
//            // 3. Reservation의 예약 현황이 취소가 아닌 것 빼고 다 불러오기
//            if(r.getR_result() == 1) {
//                // 예약 취소인 것
//                reservation.remove(i);
//            }
//            // 예약 완료 & 예약 대기는 패쓰~~
//
//            i++;
//        }
//
//        System.out.println("2222");
//        return reservation;
        return null;
    }




}
