package com.example.JakSim.trainer.model;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


public class TrainerDaoTest {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public TrainerDaoTest(DataSource ds) {jdbcTemplate = new JdbcTemplate(ds);}
    public void TrainerInsert(TrainerDo trainerDo) {
        this.sql = "INSERT INTO USER_TRAINER values(USER_TRAINER_SEQ.NEXTVAL,?,?,?,?)";

        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new TrainerRegisterPreparedTest(trainerDo, sql), keyHolder);
        }catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        System.out.println("성공?");
        }
}