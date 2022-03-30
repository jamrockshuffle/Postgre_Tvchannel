package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.sunday.SundayDAOImpl;
import com.arch.tvchannel.dto.day.DayDTOCreate;
import com.arch.tvchannel.dto.day.DayDTOUpdate;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Saturday;
import com.arch.tvchannel.model.Sunday;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.SundayRepository;
import com.arch.tvchannel.service.sunday.SundayServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sunday")
public class SundayController {

    @Autowired
    ProgramRepository programRepository;

    @Autowired
    SundayRepository dayRepository;

    @Autowired
    SundayServiceImpl service;

    @GetMapping("/get/all")
    private List<Sunday> getAll(){

        return dayRepository.findAll();
    }

    @GetMapping("/get/{id}")
    private Sunday getById(@PathVariable Long id){

        return dayRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    private List<Sunday> deleteById(@PathVariable Long id){

        dayRepository.deleteById(id);

        return dayRepository.findAll();
    }

    @PostMapping("/create")
    public Sunday create(@RequestBody Sunday day){

        return service.create(day);
    }

    @PostMapping("/update")
    public Sunday update(@RequestBody Sunday day){

        return service.update(day);
    }

    @Operation(summary = " DTO Sunday creation",
            description = " Adds new object to the Sunday list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    public Sunday createDTO(@RequestBody DayDTOCreate day){

        return service.createDTO(day);
    }

    @Operation(summary = " DTO Sunday updating",
            description = " Updates Sunday with specified id")
    @PostMapping("/updateDTO")
    public Sunday updateDTO(@RequestBody DayDTOUpdate day){

        return service.updateDTO(day);
    }
}
