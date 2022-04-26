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
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('ADMIN, USER')")
    private List<Sunday> getAll(){

        return dayRepository.findAll();
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN, USER')")
    private Sunday getById(@PathVariable Long id){

        return dayRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    private List<Sunday> deleteById(@PathVariable Long id){

        dayRepository.deleteById(id);

        return dayRepository.findAll();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Sunday create(@RequestBody Sunday day){

        return service.create(day);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Sunday update(@RequestBody Sunday day){

        return service.update(day);
    }

    @Operation(summary = " DTO Sunday creation",
            description = " Adds new object to the Sunday list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Sunday createDTO(@RequestBody DayDTOCreate day){

        return service.createDTO(day);
    }

    @Operation(summary = " DTO Sunday updating",
            description = " Updates Sunday with specified id")
    @PostMapping("/updateDTO")
    @PreAuthorize("hasRole('ADMIN')")
    public Sunday updateDTO(@RequestBody DayDTOUpdate day){

        return service.updateDTO(day);
    }
}
