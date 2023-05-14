package com.example.JakSim.trainer.model;

import com.example.JakSim.login.model.UserInfo;
import com.example.JakSim.login.model.UserRowMapper;
import com.example.JakSim.trainer.model.rowmapper.*;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


import java.util.ArrayList;
import java.util.List;

public class TrainerDao {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public TrainerDao(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }

    /**
     * 트레이너 검색시 사용되는 트레이너 목록 조회입니다.
     * @return trainerList. 검색된 리스트가 반환됩니다.
     */
    public List<TrainerDo> getAllTrainer(){
        List<TrainerDo> trainerList = new ArrayList<TrainerDo>();
        this.sql = "select * from user_trainer order by ut_idx desc";

        try{
            trainerList = jdbcTemplate.query(this.sql, new TrainerRowMapper());
        }catch(Exception e){
            System.out.println("Nop");
        }
        return trainerList;
    }

    public TrainerDo getTrainer(int idx){
        TrainerDo trainerDo = new TrainerDo();
        this.sql = "select * from user_trainer where ut_idx = ?";
        try{
            trainerDo = jdbcTemplate.queryForObject(this.sql, new TrainerRowMapper(), idx);
        }catch(Exception e){
            System.out.println("Nop");
        }
        return trainerDo;
    }

    public TrainerDo getTrainerByUserId(String userId){
        TrainerDo trainerDo = new TrainerDo();
        this.sql = "select * from user_trainer where user_id = ?";
        try{
            trainerDo = jdbcTemplate.queryForObject(this.sql, new TrainerRowMapper(), userId);
        }catch(Exception e){
            System.out.println("Nop");
        }
        return trainerDo;
    }

    public UserInfo getTrainerNameByIdx(int ut_idx){
        UserInfo userInfo = new UserInfo();
        this.sql = "SELECT * " +
                "FROM user_info " +
                "INNER JOIN user_trainer ON user_info.user_id = user_trainer.user_id " +
                "WHERE user_trainer.ut_idx = ?";
        try{
            userInfo = jdbcTemplate.queryForObject(this.sql, new UserRowMapper(), ut_idx);
        }catch(Exception e){
            System.out.println("Nop");
        }
        return userInfo;
    }

    /**
     * 트레이너 한 명에게 여러 장의 이미지가 들어갈 수 있으므로 List를 반환형으로 뒀습니다.
     * @param idx 찾으려는 트레이너의 등록번호
     * @return List<>로 반환됩니다.
     */
    public List<TrainerImageDo> getTrainerImage(int idx){
        List<TrainerImageDo> imageList = new ArrayList<>();
        this.sql = "select * from trainer_image where ut_idx = ?";
        try{
            imageList = jdbcTemplate.query(this.sql, new TrainerImageMapper(), idx);
        }catch(Exception e){
            System.out.println("Nop");
        }
        return imageList;
    }
    public List<TrainerCareerDo> getTrainerCareer(int idx){
        List<TrainerCareerDo> careerList = new ArrayList<>();
        this.sql = "select * from trainer_career where ut_idx = ?";
        try{
            careerList = jdbcTemplate.query(this.sql, new TrainerCareerMapper(), idx);
        }catch(Exception e){
            System.out.println("Nop");
        }
        return careerList;
    }
    public List<TrainerExpertDo> getTrainerExpert(int idx){
        List<TrainerExpertDo> expertList = new ArrayList<>();
        this.sql = "select * from trainer_expert where ut_idx = ?";
        try{
            expertList = jdbcTemplate.query(this.sql, new TrainerExpertMapper(), idx);
        }catch(Exception e){
            System.out.println("Nop");
        }
        return expertList;
    }

    public List<TrainerCertDo> getTrainerCert(int idx){
        List<TrainerCertDo> certList = new ArrayList<>();
        sql = "select * from trainer_cert where ut_idx = ?";
        try{
            certList = jdbcTemplate.query(sql, new TrainerCertMapper(), idx);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
        }
        return certList;
    }

    public List<TrainerPtDo> getTrainerPt(int idx){
        List<TrainerPtDo> ptList = new ArrayList<>();
        this.sql = "select * from trainer_pt where ut_idx = ?";
        try{
            ptList = jdbcTemplate.query(this.sql, new TrainerPtMapper(), idx);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
        }

        return ptList;
    }

    public void insertTrainerDo(TrainerDo trainer){
        String sql = "insert into user_trainer " +
                "values(user_trainer_seq.nextval, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sql, trainer.getUserId(),
                trainer.getIntroduce(), trainer.getInsta(), trainer.getGym());
        System.out.println(result + "개 행 삽입 성공 insertTrainerDo");
    }

    public void insertTrainerExpert(int idx, int experts){
        System.out.println("idx: " + idx + " ::: " + "expert: " + experts);
        String sql = "insert into trainer_expert " +
                "values(trainer_expert_seq.nextval, ?, ?)";
        int result = jdbcTemplate.update(sql, idx, experts);
        System.out.println(result + "개 행 삽입 성공 insertTrainerExpert");
    }

    public void insertCert(int idx, String cert){
        String sql = "insert into trainer_cert " +
                "values(trainer_cert_seq.nextval, ?, ?, '-')";
        int result = jdbcTemplate.update(sql, idx, cert);
        System.out.println(result + "개 행 삽입 성공 insertCert");
    }

    public void insertCareer(int idx, String date, String content){
        String sql = "insert into trainer_career " +
                "values(trainer_career_seq.nextval, ?, ?)";
        int result = jdbcTemplate.update(sql, idx, date+ " " + content);
        System.out.println(result + "개 행 삽입 성공 insertCareer");
    }

    public void insertPt(int idx, int type, int month, int times, int price){
        String sql = "insert into trainer_pt(tp_idx, ut_idx, tp_month,tp_times, tp_price, tp_type, tp_c_dt) " +
                "values(trainer_pt_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
        int result = jdbcTemplate.update(sql, idx, month, times, price, type);
        System.out.println(result + "개 행 삽입 성공 insertPT");
    }

    public void insertTrainerImages(int idx, String path) {
        String sql = "insert into trainer_image " +
                "values(trainer_image_seq.nextval, ?, ?)";
        int result = jdbcTemplate.update(sql, idx, path);
        System.out.println(result + "개 행 삽입 성공 insertImages");
    }

    public void updateTrainerDo(TrainerDo trainerDo) {
        String sql = "update user_trainer " +
                "set ut_insta = ?, " +
                "ut_intro = ?, " +
                "ut_gym = ?" +
                "where ut_idx = ?";
        int result = jdbcTemplate.update(sql, trainerDo.getInsta(),
                trainerDo.getIntroduce(), trainerDo.getGym(),  trainerDo.getId());
        System.out.println(result + "개 행 수정 성공 updateTrainerDo");
    }

    public void updateTrainerExpert(int utIdx, int expert) {
        String sql = "update trainer_expert " +
                "set te_expert = ? " +
                "where ut_idx = ?";
        int result = jdbcTemplate.update(sql, expert, utIdx);
        System.out.println(result + "개 행 수정 성공 updateTrainerExpert");
    }

    public void updateCareer(int utIdx, String date, String content) {
        String sql = "update trainer_career " +
                "set tcar_content = ? " +
                "where ut_idx = ?";
        int result = jdbcTemplate.update(sql, date+ " " + content, utIdx);
        System.out.println(result + "개 행 수정 성공 updateCareer");
    }


    public void updateCert(int utIdx, String cert) {
        String sql = "update trainer_cert " +
                "set tc_name = ? " +
                "where ut_idx = ?";
        int result = jdbcTemplate.update(sql, cert, utIdx);
        System.out.println(result + "개 행 수정 성공 updateCert");
    }


    public void updatePt(int idx, int type, int month, int times, int price) {
        String sql = "update trainer_pt " +
                "set tp_times = ?, " +
                "tp_month = ?, " +
                "tp_type = ?, " +
                "tp_price = ? " +
                "where ut_idx = ?";
        int result = jdbcTemplate.update(sql, times, month, type, price, idx);
        System.out.println(result + "개 행 수정 성공 updatePt");
    }

    public void updateTrainerImages(int utIdx, String path) {
        String sql = "update trainer_image " +
                "set ti_path = ? " +
                "where ut_idx = ?";
        int result = jdbcTemplate.update(sql, path, utIdx);
        System.out.println(result + "개 행 수정 성공 updateImage");
    }
}