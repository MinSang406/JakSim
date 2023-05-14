package com.example.JakSim.timetable;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/timetable")
@RequiredArgsConstructor
public class TimetableController {
    private final TimetableService timetableService;

    // 트레이너 시간표 조회_reservation-MAIN
    @GetMapping("/{date}")
    @ResponseBody
    public List<TimetableDo> timeTableList(@AuthenticationPrincipal User user, @PathVariable("date") String date) {
        return timetableService.searchTimetable(user.getUsername(), date);
    }

    @GetMapping("/res")
    public String reservation(){
        return "content/trainer/reservation";
    }

    @PostMapping("/res/action")
    public String resAction(@AuthenticationPrincipal User user, TimeTableInfo timetable){
        String[] elements =  timetable.getTrainer_reservation_display().split("/");
        TimetableDo timetableDo = new TimetableDo();

        timetableDo.setT_start_t(elements [0]);
        timetableDo.setT_end_t(elements[1]);
        timetableDo.setT_type(exchangeType(elements[2]));
        timetableDo.setT_max(Integer.parseInt(elements[3]));
        timetableDo.setT_cur(0);

        List<TimetableDo> trainerTimetableDoList = new ArrayList<>();
        trainerTimetableDoList.add(timetableDo);
        System.out.println("누가 이기나 보자");
        for(TimetableDo item : trainerTimetableDoList)
            System.out.println(item.toString());

        timetableService.registerTimetables(user.getUsername(), trainerTimetableDoList);
        return "redirect:/";
    }

    private int exchangeType(String type) {
        int type_num =1;
        if (type.equals("gather"))
            type_num = 2;
        return type_num;
    }
}
