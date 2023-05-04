package com.example.JakSim.Timetable.model;

import com.example.JakSim.Timetable.domain.Timetable;
import com.example.JakSim.Timetable.domain.TimetableRepository;
import com.example.JakSim.Timetable.dto.TimetableRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TimetableService {

    private final TimetableRepository timetableRepository;
    @Transactional(readOnly = true)
    public List<Timetable> searchAllTimetable(String id, TimetableRequestDto timetableRequestDto) {
        int utIdx = timetableRequestDto.getUt_idx();

        return timetableRepository.findTimetableByUt_idx(utIdx);
    }
}
