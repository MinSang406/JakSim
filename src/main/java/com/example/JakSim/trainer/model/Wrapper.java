package com.example.JakSim.trainer.model;

import lombok.Data;

import java.util.List;

@Data
public class Wrapper {

    private String gym;
    private double avgScore;
    private String userName;
    private List<Integer> expList;
    private List<String> certs;
    private List<Integer> ptTypeList;
    private int reviewCount;
    private int utIdx;
    private String img;
}
