package com.example.JakSim.Timetable.controller;

import com.example.JakSim.Timetable.domain.Timetable;
import com.example.JakSim.Timetable.model.TimetableDao;
import com.example.JakSim.Timetable.model.TimetableService;
import groovy.util.logging.Slf4j;
import org.apache.juli.logging.Log;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/Timetable")
public class TimetableController {
    private TimetableService timetableService;
    private Log log;
    @Autowired
    private DataSource ds;

    // 일반 PT사용자가 캘린더 예약 현황 확인_첫 페이지
    @GetMapping
    public String timetable(@PathVariable String id, Model model) {

//        log.error("Helllllllolhlehfoaisjofajsofjaosijfoaseijfoi");
//        List<Timetable> dto = timetableService.searchAllTimetable(id, timetableRequestDto);
//
//log.error(dto);

        TimetableDao dao = new TimetableDao(ds);
        model.addAttribute("timetable", timetableService.searchAllTimetable(id));
        return "content/timetable/timetable";
    }



}
