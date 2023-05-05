package com.example.JakSim.trainer.model;

import com.example.JakSim.trainer.model.TrainerDo;
import com.example.JakSim.login.model.UserRowMapper;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;

public class TrainerDao {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public TrainerDao(DataSource ds) {jdbcTemplate = new JdbcTemplate(ds);}

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

    public void TrainerExpInsert(TrainerDo trainerDo) {
        this.sql = "INSERT INTO TRAINER_EXPERT values(TRAINER_EXPERT_SEQ.NEXTVAL,?,?)";

        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new TrainerExpRegisterPrepared(trainerDo, sql), keyHolder);
        }catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        System.out.println("성공?");
    }

    public void TrainerCertInsert(TrainerDo trainerDo) {
        this.sql = "INSERT INTO TRAINER_CERT values(TRAINER_CERT_SEQ.NEXTVAL,?,?,?)";

        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new TrainerCertRegisterPrepared(trainerDo, sql), keyHolder);
        }catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        System.out.println("성공?");
    }
}




