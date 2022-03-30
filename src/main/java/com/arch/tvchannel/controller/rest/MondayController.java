package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.program.ProgramDAOImpl;
import com.arch.tvchannel.dto.day.DayDTOCreate;
import com.arch.tvchannel.dto.day.DayDTOUpdate;
import com.arch.tvchannel.model.Friday;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Program;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.service.monday.MondayServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/monday")
public class MondayController {

    @Autowired
    ProgramRepository programRepository;

    @Autowired
    MondayRepository dayRepository;

    @Autowired
    MondayServiceImpl service;

    @GetMapping("/get/all")
    private List<Monday> getAll(){

        return dayRepository.findAll();
    }

    @GetMapping("/get/{id}")
    private Monday getById(@PathVariable Long id){

        return dayRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    private List<Monday> deleteById(@PathVariable Long id){

        dayRepository.deleteById(id);

        return dayRepository.findAll();
    }

    @PostMapping("/create")
    public Monday create(@RequestBody Monday day){

        return service.create(day);
    }

    @PostMapping("/update")
    public Monday update(@RequestBody Monday day){

        return service.update(day);
    }

    @Operation(summary = " DTO Monday creation",
            description = " Adds new object to the Monday list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    public Monday createDTO(@RequestBody DayDTOCreate day){

        return service.createDTO(day);
    }

    @Operation(summary = " DTO Monday updating",
            description = " Updates Monday with specified id")
    @PostMapping("/updateDTO")
    public Monday updateDTO(@RequestBody DayDTOUpdate day){

        return service.updateDTO(day);
    }
}
