package com.example.JakSim.reservation;

import com.example.JakSim.login.model.UserDao;
import com.example.JakSim.timetable.TimetableDo;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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
    private UserDao userDao;

    // PT 사용자 캘린더 예약 현황 확인_MAIN
    @GetMapping()
    public String ReservationList(@AuthenticationPrincipal User user, Model model) {
        List<ReservationUser> reservationList = reservationService.searchAllReservation(user.getUsername());

        if(reservationList.isEmpty()) {
            System.out.println("ReservationList_is_null");
        } else {
            model.addAttribute("reservationList", reservationList);
        }
        return "content/timetable/timetable";
    }

    // PT 예약 가능 여부(현재 날짜에 예약이 있나?)
    @GetMapping("/available/{date}")
    @ResponseBody
    public Boolean ReservationAvailable(@AuthenticationPrincipal User user, @PathVariable("date") String date) {
        if(!reservationService.reservationAvailable(user.getUsername(), date)) {
            return false;
        }
        if(userDao.ptCnt(user.getUsername()) < 1) {
            return false;
        }

        return true;
    }

    // PT사용자 예약 버튼(2번째 폼 제출)
    @GetMapping("/reservate/{date}")
    @ResponseBody
    public Boolean Reservation(@AuthenticationPrincipal User user, @PathVariable("date") String date) {

        return reservationService.register(user.getUsername(), date); // yyyy-m-dd HH24:mm:ss
    }

    // PT 사용자 예약 취소_Main 화면에서
    @GetMapping("/cancel/{date}")
    @ResponseBody
    public Boolean ReservationCancle(@AuthenticationPrincipal User user, @PathVariable("date") String date) {

        return reservationService.delete(user.getUsername(), date);
    }
}
