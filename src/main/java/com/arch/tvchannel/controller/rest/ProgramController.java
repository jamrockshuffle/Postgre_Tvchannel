package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.model.Program;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.TypeRepository;
import com.arch.tvchannel.dao.program.ProgramDAOImpl;
import com.arch.tvchannel.service.program.ProgramServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/program")
public class ProgramController {

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    ProgramRepository programRepository;

    @Autowired
    ProgramServiceImpl service;

    @GetMapping("/get/all")
    private List<Program> getAll(){

        return programRepository.findAll();
    }

    @GetMapping("/get/{id}")
    private Program getById(@PathVariable Long id){

        return programRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    private List<Program> deleteById(@PathVariable Long id){

        programRepository.deleteById(id);

        return programRepository.findAll();
    }

    @PostMapping("/create")
    public Program create(@RequestBody Program program){

        return service.create(program);
    }

    @PostMapping("/update")
    public Program update(@RequestBody Program program){

        return service.update(program);
    }
}
