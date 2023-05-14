package com.example.JakSim.trainer.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrainerPtDo {
    private int idx;
    private int ut_idx;
    private int times;
    private int month;
    private int price;
    private int type;
    private LocalDateTime createDate;
}