package com.example.JakSim.Timetable.dto;

import com.example.JakSim.Timetable.domain.Timetable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TimetableRequestDto {
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

    public Timetable toEntity() {
        return Timetable.builder()
                .t_idx(t_idx)
                .ut_idx(ut_idx)
                .t_start_t(t_start_t)
                .t_end_t(t_end_t)
                .t_people(t_people)
                .t_type(Integer.getInteger(t_type.toString()))
                .build();
    }

}
