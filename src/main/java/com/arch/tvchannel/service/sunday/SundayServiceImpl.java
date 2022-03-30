package com.arch.tvchannel.service.sunday;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.sunday.SundayDAOImpl;
import com.arch.tvchannel.dto.day.DayDTOCreate;
import com.arch.tvchannel.dto.day.DayDTOUpdate;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Saturday;
import com.arch.tvchannel.model.Sunday;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.SaturdayRepository;
import com.arch.tvchannel.repository.SundayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class SundayServiceImpl implements ISundayService {

    @Autowired
    SundayDAOImpl dao;

    @Override
    public Sunday create(Sunday day) {

        return dao.create(day);
    }

    @Override
    public Sunday update(Sunday day) {

        return dao.update(day);
    }

    @Autowired
    SundayRepository repository;

    @Autowired
    ProgramRepository programRepository;

    public Sunday createDTO(DayDTOCreate request){

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var day = Sunday.builder()
                .id(id)
                .airingTime(LocalTime.parse(request.getAiringTime()))
                .program(programRepository.findById(request.getProgram()).get())
                .build();

        return repository.save(day);
    }

    public Sunday updateDTO(DayDTOUpdate request){

        var day = Sunday.builder()
                .id(repository.findById(request.getId()).get().getId())
                .airingTime(LocalTime.parse(request.getAiringTime()))
                .program(programRepository.findById(request.getProgram()).get())
                .build();

        return repository.save(day);
    }
}
