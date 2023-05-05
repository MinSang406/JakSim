package com.example.JakSim.Timetable.model;

import com.example.JakSim.Timetable.domain.Timetable;
import com.example.JakSim.Timetable.dto.TimetableRequest;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TimetableService {
    @Autowired
    private DataSource ds;

//    private final TimetableRepository timetableRepository;
    @Transactional(readOnly = true)
    public List<TimetableRequest> searchAllTimetable(String id) {

        TimetableDao timetableDao = new TimetableDao(ds);
        return timetableDao.findTimetableByUtIdx(id);
    }
}
