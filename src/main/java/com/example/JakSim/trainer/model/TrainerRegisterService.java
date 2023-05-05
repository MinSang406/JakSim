package com.example.JakSim.trainer.model;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
public class TrainerRegisterService {
    @Autowired
    private DataSource ds;

    public void RegistTest(TrainerDo trainerDo) throws SQLException {
        TrainerDao trainerDao = new TrainerDao(ds);
        TrainerDao trainerDaoExp = new TrainerDao(ds);
        TrainerDao trainerDaoCert = new TrainerDao(ds);
        trainerDao.TrainerInsert(trainerDo);
        trainerDaoCert.TrainerCertInsert(trainerDo);
        trainerDaoExp.TrainerExpInsert(trainerDo);
    }
}



