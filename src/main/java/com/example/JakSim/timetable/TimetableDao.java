package com.example.JakSim.timetable;

import com.example.JakSim.pay.PayMentDo;
import com.example.JakSim.pay.PayMentRowMapper;
import com.example.JakSim.reservation.ReservationDo;
import com.example.JakSim.trainer.model.TrainerPtDo;
import com.example.JakSim.trainer.model.rowmapper.TrainerPtMapper;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;

public class TimetableDao {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public TimetableDao(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public List<TimetableDo> searchAllTimetable(String userId) {

    return null;
    }

    public Boolean deleteUserTimetable(int tIdx) {
        this.sql = "delete from timetable " +
                    "where t_idx = ?";

        try {
            jdbcTemplate.update(this.sql, tIdx);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("예약 취소(시간표)가 올바르게 되지 않았습니다.");
            return false;
        }

        System.out.println("예약 취소(시간표) 완료!!");
        return true;
    }

    public void insertTimetable(TimetableDo timetableDo) {

        this.sql = "insert into timetable(t_idx, ut_idx, t_start_t, t_end_t, t_max, t_cur, t_type)" +
                "values(TIMETABLE_SEQ.NEXTVAL, ?, TO_TIMESTAMP(?, 'YYYY/MM/DD HH24:MI:SS'), TO_TIMESTAMP(?, 'YYYY/MM/DD HH24:MI:SS'), ?, ?, ?)";
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new TrainerTimetalbeRegisterPreparedStatementCreator(timetableDo, sql), keyHolder);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        System.out.println("insert");
    }
    public TimetableDo updateTimetable(TimetableDo timetableDo) {
        this.sql = "UPDATE timetable SET t_start_t= to_timestamp(?, 'yyyy/mm/dd HH24:MI:SS')," +
                " t_end_t= to_timestamp(?, 'yyyy/mm/dd HH24:MI:SS'), t_max=?, t_cur=?, t_type=? WHERE t_idx=?";

        try {
            int rowsAffected = jdbcTemplate.update(this.sql, timetableDo.getT_start_t(), timetableDo.getT_end_t(), timetableDo.getT_max(),timetableDo.getT_cur(), timetableDo.getT_type(), timetableDo.getT_idx());
            if (rowsAffected > 0) {
                System.out.println("update");
                return new TimetableDo();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public int findTpByUser(String userId) {
        PayMentDo payMentDo;
        this.sql = "select * from payment where user_id = ? and p_validate = 1";

        try {
            payMentDo = jdbcTemplate.queryForObject(this.sql, new PayMentRowMapper(), userId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("유효한 결제 내역이 없습니다.");
            return -1;
        }

        return payMentDo.getTp_idx();
    }

    public TimetableDo findByDate(String date) {
        System.out.println("helllllo");
        TimetableDo timetableDo;
        this.sql = "select * from timetable where T_START_T = TO_TIMESTAMP('?', 'YYYY-MM-DD HH24:MI:SS')";

        try {
            timetableDo = jdbcTemplate.queryForObject(this.sql, new TimetableRowMapper(), date);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("해당 날짜 또는 시간의 시간표가 없습니다.");
            return null;
        }

        System.out.println("helllllo" + timetableDo);

        return timetableDo;
    }

    public Boolean increaseCurr(int tIdx) {
        this.sql = "update timetable set t_cur = t_vur + 1 where t_idx = tIdx";

        try {
            jdbcTemplate.update(this.sql, tIdx);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("시간표에 대한 현재 인원수 증가.");
            return false;
        }

        return true;
    }

    public int findUtByTp(int tpIdx) {
        TrainerPtDo trainerPtDo;
        this.sql = "select * from trainer_pt where tp_idx = ?";

        try {
            trainerPtDo = jdbcTemplate.queryForObject(this.sql, new TrainerPtMapper(), tpIdx);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("유효한 결제 내역이 없습니다.");
            return -1;
        }

        return trainerPtDo.getUt_idx();

    }

    public List<TimetableDo> findAllByUt(int utIdx) {
        List<TimetableDo> timetableDoList;
        this.sql = "select * from timetable where ut_idx = ?";

        try {
            timetableDoList = jdbcTemplate.query(this.sql, new TimetableRowMapper(), utIdx);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("유효한 결제 내역이 없습니다.");
            return null;
        }

        return timetableDoList;

    }


}
