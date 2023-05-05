package com.example.JakSim.reservation;

import groovy.util.logging.Slf4j;
import org.apache.juli.logging.Log;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/Reservation")
public class ReservationController {
    @Autowired
    private DataSource ds;

    ReservationService reservationService;


    private Log log;

    // 일반 PT사용자가 캘린더 예약 현황 확인_첫 페이지
    @GetMapping("/{userId}")
    public String ReservationList(@PathVariable("userId") String id, Model model) {

        reservationService = new ReservationService();

//        log.error("Helllllllolhlehfoaisjofajsofjaosijfoaseijfoi");

        model.addAttribute("timetable", reservationService.searchAllReservation(id));

        return "content/timetable/timetable";
    }
}
