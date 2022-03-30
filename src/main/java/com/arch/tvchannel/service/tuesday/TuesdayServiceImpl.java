package com.arch.tvchannel.service.tuesday;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.tuesday.TuesdayDAOImpl;
import com.arch.tvchannel.dto.day.DayDTOCreate;
import com.arch.tvchannel.dto.day.DayDTOUpdate;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Thursday;
import com.arch.tvchannel.model.Tuesday;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.ThursdayRepository;
import com.arch.tvchannel.repository.TuesdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class TuesdayServiceImpl implements ITuesdayService {

    @Autowired
    TuesdayDAOImpl dao;

    @Override
    public Tuesday create(Tuesday day) {

        return dao.create(day);
    }

    @Override
    public Tuesday update(Tuesday day) {

        return dao.update(day);
    }

    @Autowired
    TuesdayRepository repository;

    @Autowired
    ProgramRepository programRepository;

    public Tuesday createDTO(DayDTOCreate request){

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var day = Tuesday.builder()
                .id(id)
                .airingTime(LocalTime.parse(request.getAiringTime()))
                .program(programRepository.findById(request.getProgram()).get())
                .build();

        return repository.save(day);
    }

    public Tuesday updateDTO(DayDTOUpdate request){

        var day = Tuesday.builder()
                .id(repository.findById(request.getId()).get().getId())
                .airingTime(LocalTime.parse(request.getAiringTime()))
                .program(programRepository.findById(request.getProgram()).get())
                .build();

        return repository.save(day);
    }
}
