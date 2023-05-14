package com.example.JakSim.reservation;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservationUser {
    private int res_idx;
    private int t_idx;
    private String user_id;
    private String res_c_dt;
    private int ut_idx;
    private String t_start_t;
    private String t_end_t;
    private int t_max;
    private int t_cur;
    private int t_type;
}
