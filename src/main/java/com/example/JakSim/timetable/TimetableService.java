package com.example.JakSim.timetable;

import com.example.JakSim.reservation.ReservationDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimetableService {
    @Autowired
    private DataSource ds;


}
