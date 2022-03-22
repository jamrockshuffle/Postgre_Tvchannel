package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.sunday.SundayDAOImpl;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Sunday;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.SundayRepository;
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
}
