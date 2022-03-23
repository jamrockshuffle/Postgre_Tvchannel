package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.saturday.SaturdayDAOImpl;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Saturday;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.SaturdayRepository;
import com.arch.tvchannel.service.saturday.SaturdayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    private List<Saturday> getAll(){

        return dayRepository.findAll();
    }

    @GetMapping("/get/{id}")
    private Saturday getById(@PathVariable Long id){

        return dayRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    private List<Saturday> deleteById(@PathVariable Long id){

        dayRepository.deleteById(id);

        return dayRepository.findAll();
    }

    @PostMapping("/create")
    public Saturday create(@RequestBody Saturday day){

        return service.create(day);
    }

    @PostMapping("/update")
    public Saturday update(@RequestBody Saturday day){

        return service.update(day);
    }
}
