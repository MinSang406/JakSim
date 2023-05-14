package com.example.JakSim.trainer.model.rowmapper;

import com.example.JakSim.trainer.model.SearchResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainerSearchRowMapper implements RowMapper<SearchResult> {
    @Override
    public SearchResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        SearchResult searchResult = new SearchResult();

        searchResult.setUt_idx(rs.getInt("UT_IDX"));
        searchResult.setUser_id(rs.getString("USER_ID"));
        searchResult.setGym(rs.getString("UT_GYM"));
        searchResult.setExpert(rs.getInt("TE_EXPERT"));
        searchResult.setType(rs.getInt("TP_TYPE"));

        return searchResult;
    }
}
