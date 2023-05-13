package com.example.JakSim.reservation;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
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

    // PT 사용자가 캘린더 예약 현황 확인_첫 페이지
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

    // PT사용자 예약
    @PostMapping("/reservate/{userId}")
    @ResponseBody
    public Boolean Reservation(@PathVariable("userId") String userId, int tIdx, String date) {

        return reservationService.register(userId, tIdx, date);
    }

    // PT 사용자 예약 취소
    @PostMapping("/cancle/{userId}")
    @ResponseBody
    public Boolean ReservationCancle(@PathVariable("userId") String userId, int rIdx, int tIdx) {

        return reservationService.deleteReservation(userId, rIdx, tIdx);
    }
}
