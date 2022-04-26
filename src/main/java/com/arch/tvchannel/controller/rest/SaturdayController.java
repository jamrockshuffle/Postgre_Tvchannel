package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.saturday.SaturdayDAOImpl;
import com.arch.tvchannel.dto.day.DayDTOCreate;
import com.arch.tvchannel.dto.day.DayDTOUpdate;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Saturday;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.SaturdayRepository;
import com.arch.tvchannel.service.saturday.SaturdayServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/saturday")
public class SaturdayController {

    @Autowired
    ProgramRepository programRepository;

    @Autowired
    SaturdayRepository dayRepository;

    @Autowired
    SaturdayServiceImpl service;

    @GetMapping("/get/all")
    @PreAuthorize("hasAnyRole('ADMIN, USER')")
    private List<Saturday> getAll(){

        return dayRepository.findAll();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN, USER')")
    private Saturday getById(@PathVariable Long id){

        return dayRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    private List<Saturday> deleteById(@PathVariable Long id){

        dayRepository.deleteById(id);

        return dayRepository.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Saturday create(@RequestBody Saturday day){

        return service.create(day);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Saturday update(@RequestBody Saturday day){

        return service.update(day);
    }

    @Operation(summary = " DTO Saturday creation",
            description = " Adds new object to the Saturday list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Saturday createDTO(@RequestBody DayDTOCreate day){

        return service.createDTO(day);
    }

    @Operation(summary = " DTO Saturday updating",
            description = " Updates Saturday with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Saturday updateDTO(@RequestBody DayDTOUpdate day){

        return service.updateDTO(day);
    }
}
