package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.thursday.ThursdayDAOImpl;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Thursday;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.ThursdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/thursday")
public class ThursdayController {

    @Autowired
    ProgramRepository programRepository;

    @Autowired
    ThursdayRepository dayRepository;

    @Autowired
    ThursdayServiceImpl service;

    @GetMapping("/get/all")
    private List<Thursday> getAll(){

        return dayRepository.findAll();
    }

    @GetMapping("/get/{id}")
    private Thursday getById(@PathVariable Long id){

        return dayRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    private List<Thursday> deleteById(@PathVariable Long id){

        dayRepository.deleteById(id);

        return dayRepository.findAll();
    }

    @PostMapping("/create")
    public Thursday create(@RequestBody Thursday day){

        return service.create(day);
    }

    @PostMapping("/update")
    public Thursday update(@RequestBody Thursday day){

        return service.update(day);
    }
}
