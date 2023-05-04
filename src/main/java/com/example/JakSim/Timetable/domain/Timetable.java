package com.example.JakSim.Timetable.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Timetable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int t_idx;

    @Column(nullable = false)
    private int ut_idx;

    @Column(nullable = false)
    private String t_start_t;

    @Column(nullable = false)
    private String t_end_t;

    @Column(nullable = false)
    private int t_people;

    @Column(nullable = false)
    private int t_type;

    @Builder
    public Timetable(int t_idx, int ut_idx, String t_start_t, String t_end_t, int t_people, int t_type) {
        this.t_idx = t_idx;
        this.ut_idx = ut_idx;
        this.t_start_t = t_start_t;
        this.t_end_t = t_end_t;
        this.t_people = t_people;
        this.t_type = t_type;
    }
}
