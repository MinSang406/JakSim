package com.example.JakSim.reservation;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.apache.juli.logging.Log;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    private Log log;

    // 일반 PT 사용자가 캘린더 예약 현황 확인_첫 페이지
    @GetMapping("/{userId}")
    public String ReservationList(@PathVariable("userId") String id, Model model) {
        System.out.println("controller");
        model.addAttribute("reservation", reservationService.searchAllReservation(id));

        return "content/timetable/timetable";
    }

    // 일반 PT사용자가 예약하기
    @PostMapping("/{userId}")
    public String Reservation(@PathVariable("userId") String id, Model model) {
//        model.addAttribute("", reservationService.);

        return "content/timetable/timetable";
    }
}
