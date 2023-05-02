package com.example.JakSim.trainer.model;

import com.example.JakSim.trainer.model.TrainerDo;
import com.example.JakSim.login.model.UserRowMapper;
import org.apache.tomcat.jdbc.pool.DataSource;


import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;

public class TrainerDao {
    PreparedStatement pstmt;
    ResultSet rs;
    Connection con;

    public void getCon() {
        //db연동코드, Connection Pool 사용
        try {
            Context initctx = new InitialContext();
            Context envctx = (Context) initctx.lookup("java:comp/env");
            DataSource dsc = (DataSource) envctx.lookup("jdbc/pool");
            con = dsc.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//getCon end
    public void TrainerInsert(TrainerDo tDo) {
        getCon();
        try {  //sql문
            String sql = "INSERT INTO USER_TRAINER values(?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "USER_TRAINER_SEQ.NEXTVAL");
            pstmt.setString(2, tDo.getUser_id());
            pstmt.setString(3, tDo.getUintroduce());
            pstmt.setString(4, tDo.getUinsta());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void TrImgInsert(TrainerDo tDo) {
        getCon();
        try {  //sql문
            String sql = "INSERT INTO TRAINER_IMAGE values(?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "TRAINER_IMAGE_SEQ.NEXTVAL");
            pstmt.setString(2, "USER_TRAINER_SEQ.NEXTVAL");
            pstmt.setString(3, tDo.getPhoto());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void TrCertInsert(TrainerDo tDo) {
        getCon();
        try {  //sql문
            String sql = "INSERT INTO TRAINER_CERT values(?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "TRAINER_CERT_SEQ.NEXTVAL");
            pstmt.setString(2, "USER_TRAINER_SEQ.NEXTVAL");
            pstmt.setString(3, tDo.getPhoto_cert());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void TrExpInsert(TrainerDo tDo) {
        getCon();
        try {  //sql문
            String sql = "INSERT INTO TRAINER_EXPERT values(?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "TRAINER_EXPERT_SEQ.NEXTVAL");
            pstmt.setString(2, "USER_TRAINER_SEQ.NEXTVAL");
            pstmt.setString(3, tDo.getExp());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void TrCareerInsert(TrainerDo tDo) {
        getCon();
        try {  //sql문
            String sql = "INSERT INTO TRAINER_CAREER values(?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "TRAINER_EXPERT_SEQ.NEXTVAL");
            pstmt.setString(2, "USER_TRAINER_SEQ.NEXTVAL");
            pstmt.setString(3, tDo.getCareer());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void TrPTpayInsert(TrainerDo tDo) {
        getCon();
        try {  //sql문
            String sql = "INSERT INTO TRAINER_PT values(?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "TRAINER_EXPERT_SEQ.NEXTVAL");
            pstmt.setString(2, "USER_TRAINER_SEQ.NEXTVAL");
            pstmt.setString(3, tDo.getCareer());
            pstmt.setString(4, tDo.getCareer());
            pstmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}