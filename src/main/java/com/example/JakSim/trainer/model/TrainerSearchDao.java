package com.example.JakSim.trainer.model;

import com.example.JakSim.trainer.model.rowmapper.TrainerRowMapper;
import com.example.JakSim.trainer.model.rowmapper.TrainerSearchRowMapper;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class TrainerSearchDao {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public TrainerSearchDao(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }

    /**
     *
     * @param ButtonType
     * @param ptType
     * @return
     */
    public List<SearchResult> searchAllTrainer(int ButtonType, int ptType){
        List<SearchResult> trainerList = new ArrayList<SearchResult>();
        this.sql = "select distinct t.ut_idx, user_id, ut_gym, e.te_expert, p.tp_times, p.tp_type, p.tp_c_dt " +
                "from user_trainer t, trainer_expert e, trainer_pt p " +
                "where " +
                "t.ut_idx = e.ut_idx and t.ut_idx = p.ut_idx " +
                "and " +
                "te_expert = 1  "+
                "and " +
                "tp_type = 0 ";
        try{
            trainerList = jdbcTemplate.query(this.sql, new TrainerSearchRowMapper());
        }catch(Exception e){
            System.out.println("exit");
        }
        return trainerList;
    }
}
