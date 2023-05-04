package com.example.JakSim.Timetable.controller;

import com.example.JakSim.Timetable.domain.Timetable;
import com.example.JakSim.Timetable.dto.TimetableRequestDto;
import com.example.JakSim.Timetable.model.TimetableService;
import groovy.util.logging.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

import static java.lang.System.console;

@Slf4j
@Controller
@RequestMapping("/Timetable")
public class TimetableController {
    private TimetableService timetableService;
    private Log log;

    // 일반 PT사용자가 캘린더 예약 현황 확인_첫 페이지
    @GetMapping
    public String timetable(@PathVariable String id, @RequestBody TimetableRequestDto timetableRequestDto) {

        log.error("Helllllllolhlehfoaisjofajsofjaosijfoaseijfoi");
        List<Timetable> dto = timetableService.searchAllTimetable(id, timetableRequestDto);

log.error(dto);

        return "content/timetable/timetable";
    }



}
