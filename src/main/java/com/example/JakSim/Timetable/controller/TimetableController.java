package com.example.JakSim.Timetable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimetableController {
    @GetMapping("/calendar")
    public String calendar(){
        String result = "";

        return "content/calendar/calendar";
    }
}
