package com.example.JakSim.pay;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PayMentDo {

    private int p_idx;
    private String user_id;
    private int tp_idx;
    private int p_refound;
    private int validate;
    private String p_c_dt;
    private String p_m_dt;

}
