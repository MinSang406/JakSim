package com.example.JakSim.reservation;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservationDo {
//    public enum rType {
//        WAITING,
//        CANCLE,
//        COMPLETE
//    }

    private int r_idx;
    private int t_idx;
    private String user_id;
    private String r_c_dt;

//    @Override
//    public String toString() {
//        return "Reservation{" +
//                "r_idx='" + r_idx + '\'' +
//                ", t_idx='" + t_idx + '\'' +
//                ", tp_idx=" + tp_idx +
//                ", user_id='" + user_id + '\'' +
//                ", r_c_dt='" + r_c_dt + '\'' +
//                ", r_result=" + r_result +
//                '}';
//    }
}
