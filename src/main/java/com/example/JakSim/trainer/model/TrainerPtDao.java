package com.example.JakSim.trainer.model;

import com.example.JakSim.trainer.model.rowmapper.TrainerPtMapper;
import com.example.JakSim.trainer.model.rowmapper.TrainerRowMapper;
import com.example.JakSim.trainer.model.rowmapper.TrainerSearchRowMapper;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class TrainerPtDao {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public TrainerPtDao(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public List<TrainerPtDo> searchAllMyPayment(int tpIdx){
        List<TrainerPtDo> paymentList = new ArrayList<TrainerPtDo>();
        this.sql = "select TP_TIMES, TP_MONTH, TP_PRICE from TRAINER_PT where TP_IDX='?'";
        try{
            paymentList = jdbcTemplate.query(this.sql, new TrainerPtMapper(), tpIdx);
        }catch(Exception e){
            System.out.println("개쌔끼야");
        }
        return paymentList;
    }
}
