package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.dto.program.ProgramDTOCreate;
import com.arch.tvchannel.dto.program.ProgramDTOUpdate;
import com.arch.tvchannel.dto.type.TypeDTOCreate;
import com.arch.tvchannel.dto.type.TypeDTOUpdate;
import com.arch.tvchannel.model.Program;
import com.arch.tvchannel.model.Type;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.TypeRepository;
import com.arch.tvchannel.dao.program.ProgramDAOImpl;
import com.arch.tvchannel.service.program.ProgramServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
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

        //Program program = new Program(1L, "qweewq", typeRepository.getById(1L));
        //programRepository.save(program);

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

    @Operation(summary = " DTO Program creation",
            description = " Adds new program to the Program list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    public Program createDTO(@RequestBody ProgramDTOCreate program){

        return service.createDTO(program);
    }

    @Operation(summary = " DTO Program updating",
            description = " Updates Program with specified id")
    @PostMapping("/updateDTO")
    public Program updateDTO(@RequestBody ProgramDTOUpdate program){

        return service.updateDTO(program);
    }
}
