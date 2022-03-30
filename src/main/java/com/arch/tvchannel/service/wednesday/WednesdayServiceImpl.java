package com.arch.tvchannel.service.wednesday;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.wednesday.WednesdayDAOImpl;
import com.arch.tvchannel.dto.day.DayDTOCreate;
import com.arch.tvchannel.dto.day.DayDTOUpdate;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Tuesday;
import com.arch.tvchannel.model.Wednesday;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.TuesdayRepository;
import com.arch.tvchannel.repository.WednesdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;

@Repository
public class WednesdayServiceImpl implements IWednesdayService {

    @Autowired
    WednesdayDAOImpl dao;

    @Override
    public Wednesday create(Wednesday day) {

        return dao.create(day);
    }

    @Override
    public Wednesday update(Wednesday day) {

        return dao.update(day);
    }

    @Autowired
    WednesdayRepository repository;

    @Autowired
    ProgramRepository programRepository;

    public Wednesday createDTO(DayDTOCreate request){

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var day = Wednesday.builder()
                .id(id)
                .airingTime(LocalTime.parse(request.getAiringTime()))
                .program(programRepository.findById(request.getProgram()).get())
                .build();

        return repository.save(day);
    }

    public Wednesday updateDTO(DayDTOUpdate request){

        var day = Wednesday.builder()
                .id(repository.findById(request.getId()).get().getId())
                .airingTime(LocalTime.parse(request.getAiringTime()))
                .program(programRepository.findById(request.getProgram()).get())
                .build();

        return repository.save(day);
    }
}
