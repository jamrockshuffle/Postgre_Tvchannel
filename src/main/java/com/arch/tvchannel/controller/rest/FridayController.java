package com.arch.tvchannel.controller.rest;

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
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.service.friday.FridayServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/friday")
public class FridayController {

    @Autowired
    ProgramRepository programRepository;

    @Autowired
    FridayRepository dayRepository;

    @Autowired
    FridayServiceImpl service;

    @GetMapping("/get/all")
    @PreAuthorize("hasAnyRole('ADMIN, USER')")
    private List<Friday> getAll(){

        return dayRepository.findAll();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN, USER')")
    private Friday getById(@PathVariable Long id){

        return dayRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    private List<Friday> deleteById(@PathVariable Long id){

        dayRepository.deleteById(id);

        return dayRepository.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Friday create(@RequestBody Friday day){

        return service.create(day);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Friday update(@RequestBody Friday day){

        return service.update(day);
    }

    @Operation(summary = " DTO Friday creation",
            description = " Adds new object to the Friday list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Friday createDTO(@RequestBody DayDTOCreate day){

        return service.createDTO(day);
    }

    @Operation(summary = " DTO Friday updating",
            description = " Updates Friday with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Friday updateDTO(@RequestBody DayDTOUpdate day){

        return service.updateDTO(day);
    }
}
