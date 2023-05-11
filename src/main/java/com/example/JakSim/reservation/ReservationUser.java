package com.example.JakSim.reservation;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservationUser {
    private int r_idx;
    private int t_idx;
    private int ut_idx;
    private int tp_idx;
    private String user_id;
    private String r_c_dt;
    private int r_result;
    private String t_start_t;
    private String t_end_t;
    private int t_people;
    private int t_type;
}
