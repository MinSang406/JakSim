package com.example.JakSim.timetable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TimetableDo {
    private int t_idx;
    private int ut_idx;
    private String t_start_t;
    private String t_end_t;
    private int t_people;
    private int t_type;

}
