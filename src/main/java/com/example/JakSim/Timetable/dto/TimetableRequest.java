package com.example.JakSim.Timetable.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TimetableRequest {
    public enum tType {
        CONSULTING,
        OTO,
        ORGANIZTION
    }

    private int t_idx;
    private int ut_idx;
    private String t_start_t;
    private String t_end_t;
    private int t_people;
    private tType t_type;

    @Override
    public String toString() {
        return "Timetable{" +
                "t_idx='" + t_idx + '\'' +
                ", ut_idx='" + ut_idx + '\'' +
                ", t_start_t=" + t_start_t +
                ", t_end_t='" + t_end_t + '\'' +
                ", t_people='" + t_people + '\'' +
                ", t_type=" + t_type +
                '}';
    }

}
