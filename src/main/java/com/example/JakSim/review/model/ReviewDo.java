package com.example.JakSim.review.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDo {
    private int idx;
    private String user_id;
    private int ut_idx;
    private String content;
    private int star;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
}
