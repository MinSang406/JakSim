package com.example.JakSim.reservation;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private DataSource ds;
    private ReservationDao reservationDao;
    public List<Reservation> searchAllReservation(String userId) {
        reservationDao.findReservationByUserId(userId);

        return null;
    }
}
