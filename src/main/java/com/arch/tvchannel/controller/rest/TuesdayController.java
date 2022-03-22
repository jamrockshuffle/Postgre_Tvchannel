package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.tuesday.TuesdayDAOImpl;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Tuesday;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.TuesdayRepository;
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
}
