package com.arch.tvchannel.service.thursday;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.thursday.ThursdayDAOImpl;
import com.arch.tvchannel.dto.day.DayDTOCreate;
import com.arch.tvchannel.dto.day.DayDTOUpdate;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Sunday;
import com.arch.tvchannel.model.Thursday;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.SundayRepository;
import com.arch.tvchannel.repository.ThursdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ThursdayServiceImpl implements IThursdayService {

    @Autowired
    ThursdayDAOImpl dao;

    @Override
    public Thursday create(Thursday day) {

        return dao.create(day);
    }

    @Override
    public Thursday update(Thursday day) {

        return dao.update(day);
    }

    @Autowired
    ThursdayRepository repository;

    @Autowired
    ProgramRepository programRepository;

    public Thursday createDTO(DayDTOCreate request){

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var day = Thursday.builder()
                .id(id)
                .airingTime(LocalTime.parse(request.getAiringTime()))
                .program(programRepository.findById(request.getProgram()).get())
                .build();

        return repository.save(day);
    }

    public Thursday updateDTO(DayDTOUpdate request){

        var day = Thursday.builder()
                .id(repository.findById(request.getId()).get().getId())
                .airingTime(LocalTime.parse(request.getAiringTime()))
                .program(programRepository.findById(request.getProgram()).get())
                .build();

        return repository.save(day);
    }
}
