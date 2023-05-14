package com.example.JakSim.timetable;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/timetable")
@RequiredArgsConstructor
public class TimetableController {
    private final TimetableService timetableService;

    // 트레이너 시간표 조회_reservation-MAIN
    @GetMapping("/timetable/{date}")
    @ResponseBody
    public List<TimetableDo> timeTableList(@AuthenticationPrincipal User user, @PathVariable("date") String date) {
        return timetableService.searchTimetable(user.getUsername(), date);
    }
}
