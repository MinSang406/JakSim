package com.example.JakSim.timetable;

import com.example.JakSim.reservation.ReservationUser;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/list/{userId}")
    @ResponseBody
    public List<Timetable> TimetableList(@PathVariable("userId") String id, Model model) {
        List<Timetable> timetableList = timetableService.searchAllTimetable(id);

        if(timetableList.isEmpty()) {
            System.out.println("Timetable_is_null");
        } else {
            model.addAttribute("timetableList", timetableList);
        }
        return timetableList;
    }
}
