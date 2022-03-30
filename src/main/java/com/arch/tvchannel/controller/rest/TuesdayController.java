package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.tuesday.TuesdayDAOImpl;
import com.arch.tvchannel.dto.day.DayDTOCreate;
import com.arch.tvchannel.dto.day.DayDTOUpdate;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Thursday;
import com.arch.tvchannel.model.Tuesday;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.TuesdayRepository;
import com.arch.tvchannel.service.tuesday.TuesdayServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tuesday")
public class TuesdayController {

    @Autowired
    ProgramRepository programRepository;

    @Autowired
    TuesdayRepository dayRepository;

    @Autowired
    TuesdayServiceImpl service;

    @GetMapping("/get/all")
    private List<Tuesday> getAll(){

        return dayRepository.findAll();
    }

    @GetMapping("/get/{id}")
    private Tuesday getById(@PathVariable Long id){

        return dayRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    private List<Tuesday> deleteById(@PathVariable Long id){

        dayRepository.deleteById(id);

        return dayRepository.findAll();
    }

    @PostMapping("/create")
    public Tuesday create(@RequestBody Tuesday day){

        return service.create(day);
    }

    @PostMapping("/update")
    public Tuesday update(@RequestBody Tuesday day){

        return service.update(day);
    }

    @Operation(summary = " DTO Tuesday creation",
            description = " Adds new object to the Tuesday list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    public Tuesday createDTO(@RequestBody DayDTOCreate day){

        return service.createDTO(day);
    }

    @Operation(summary = " DTO Tuesday updating",
            description = " Updates Tuesday with specified id")
    @PostMapping("/updateDTO")
    public Tuesday updateDTO(@RequestBody DayDTOUpdate day){

        return service.updateDTO(day);
    }
}
