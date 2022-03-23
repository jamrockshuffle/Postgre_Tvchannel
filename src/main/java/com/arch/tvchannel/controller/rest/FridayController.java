package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.dao.friday.FridayDAOImpl;
import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.model.Friday;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.repository.FridayRepository;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.service.friday.FridayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    private List<Friday> getAll(){

        return dayRepository.findAll();
    }

    @GetMapping("/get/{id}")
    private Friday getById(@PathVariable Long id){

        return dayRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    private List<Friday> deleteById(@PathVariable Long id){

        dayRepository.deleteById(id);

        return dayRepository.findAll();
    }

    @PostMapping("/create")
    public Friday create(@RequestBody Friday day){

        return service.create(day);
    }

    @PostMapping("/update")
    public Friday update(@RequestBody Friday day){

        return service.update(day);
    }
}
