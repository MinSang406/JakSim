package com.example.JakSim.reservation;

import com.example.JakSim.timetable.Timetable;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.apache.juli.logging.Log;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@Controller
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    // 일반 PT 사용자가 캘린더 예약 현황 확인_첫 페이지
    @GetMapping("/list/{userId}")
    public String ReservationList(@PathVariable("userId") String id, Model model) {
        List<ReservationUser> reservationList = reservationService.searchAllReservation(id);

        if(reservationList.isEmpty()) {
            System.out.println("ReservationList_is_null");
        } else {
            model.addAttribute("reservationList", reservationList);
        }
        return "content/timetable/timetable";
    }

    // 일반 PT사용자가 예약하기
    @PostMapping("/reservate/{userId}")
    @ResponseBody
    public Boolean Reservation(@PathVariable("userId") String userId, int tIdx, String date) {

        if(reservationService.register(userId, tIdx, date)) {
            return true;
        }

        return false;
    }

    @PostMapping("/cancle/{userId}")
    @ResponseBody
    public String ReservationCancle(@PathVariable("userId") String id, Model model) {
//        model.addAttribute("", reservationService.);

        return "content/timetable/timetable";
    }
}
