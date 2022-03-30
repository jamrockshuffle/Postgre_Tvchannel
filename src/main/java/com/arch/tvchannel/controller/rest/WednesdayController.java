package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.wednesday.WednesdayDAOImpl;
import com.arch.tvchannel.dto.day.DayDTOCreate;
import com.arch.tvchannel.dto.day.DayDTOUpdate;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Tuesday;
import com.arch.tvchannel.model.Wednesday;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.WednesdayRepository;
import com.arch.tvchannel.service.wednesday.WednesdayServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/wednesday")
public class WednesdayController {

    @Autowired
    ProgramRepository programRepository;

    @Autowired
    WednesdayRepository dayRepository;

    @Autowired
    WednesdayServiceImpl service;

    @GetMapping("/get/all")
    private List<Wednesday> getAll(){

        return dayRepository.findAll();
    }

    @GetMapping("/get/{id}")
    private Wednesday getById(@PathVariable Long id){

        return dayRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    private List<Wednesday> deleteById(@PathVariable Long id){

        dayRepository.deleteById(id);

        return dayRepository.findAll();
    }

    @PostMapping("/create")
    public Wednesday create(@RequestBody Wednesday day){

        return service.create(day);
    }

    @PostMapping("/update")
    public Wednesday update(@RequestBody Wednesday day){

        return service.update(day);
    }

    @Operation(summary = " DTO Wednesday creation",
            description = " Adds new object to the Wednesday list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    public Wednesday createDTO(@RequestBody DayDTOCreate day){

        return service.createDTO(day);
    }

    @Operation(summary = " DTO Wednesday updating",
            description = " Updates Wednesday with specified id")
    @PostMapping("/updateDTO")
    public Wednesday updateDTO(@RequestBody DayDTOUpdate day){

        return service.updateDTO(day);
    }
}
