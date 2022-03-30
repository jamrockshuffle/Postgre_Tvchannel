package com.arch.tvchannel.service.friday;

import com.arch.tvchannel.dao.friday.FridayDAOImpl;
import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dto.day.DayDTOCreate;
import com.arch.tvchannel.dto.day.DayDTOUpdate;
import com.arch.tvchannel.dto.program.ProgramDTOCreate;
import com.arch.tvchannel.dto.program.ProgramDTOUpdate;
import com.arch.tvchannel.model.Friday;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Program;
import com.arch.tvchannel.repository.FridayRepository;
import com.arch.tvchannel.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.HashSet;

@Service
public class FridayServiceImpl implements IFridayService {

    @Autowired
    FridayDAOImpl dao;

    @Override
    public Friday create(Friday day) {

        return dao.create(day);
    }

    @Override
    public Friday update(Friday day) {

        return dao.update(day);
    }

    @Autowired
    FridayRepository repository;

    @Autowired
    ProgramRepository programRepository;

    public Friday createDTO(DayDTOCreate request){

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var day = Friday.builder()
                .id(id)
                .airingTime(LocalTime.parse(request.getAiringTime()))
                .program(programRepository.findById(request.getProgram()).get())
                .build();

        return repository.save(day);
    }

    public Friday updateDTO(DayDTOUpdate request){

        var day = Friday.builder()
                .id(repository.findById(request.getId()).get().getId())
                .airingTime(LocalTime.parse(request.getAiringTime()))
                .program(programRepository.findById(request.getProgram()).get())
                .build();

        return repository.save(day);
    }
}
