package com.arch.tvchannel.service.monday;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.program.ProgramDAOImpl;
import com.arch.tvchannel.dto.day.DayDTOCreate;
import com.arch.tvchannel.dto.day.DayDTOUpdate;
import com.arch.tvchannel.model.Friday;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Program;
import com.arch.tvchannel.repository.FridayRepository;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class MondayServiceImpl implements IMondayService {

    @Autowired
    MondayDAOImpl dao;

    @Override
    public Monday create(Monday day) {

        return dao.create(day);
    }

    @Override
    public Monday update(Monday day) {

        return dao.update(day);
    }

    @Autowired
    MondayRepository repository;

    @Autowired
    ProgramRepository programRepository;

    public Monday createDTO(DayDTOCreate request){

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var day = Monday.builder()
                .id(id)
                .airingTime(LocalTime.parse(request.getAiringTime()))
                .program(programRepository.findById(request.getProgram()).get())
                .build();

        return repository.save(day);
    }

    public Monday updateDTO(DayDTOUpdate request){

        var day = Monday.builder()
                .id(repository.findById(request.getId()).get().getId())
                .airingTime(LocalTime.parse(request.getAiringTime()))
                .program(programRepository.findById(request.getProgram()).get())
                .build();

        return repository.save(day);
    }
}
