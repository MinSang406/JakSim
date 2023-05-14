package com.example.JakSim.trainer.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchResult {
    private int ut_idx;
    private String user_id;
    private String gym;
    private int expert;
    private int type; //PT유형
//    private LocalDateTime createDate;
}
