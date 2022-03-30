package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.dto.type.TypeDTOCreate;
import com.arch.tvchannel.dto.type.TypeDTOUpdate;
import com.arch.tvchannel.model.Type;
import com.arch.tvchannel.repository.TypeRepository;
import com.arch.tvchannel.service.type.TypeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/type")
@Tag(name = "type-controller", description = "Mostly GET methods with Type collection")
public class TypeController {

    //@RequestMapping(value = "/gte", method = RequestMethod.GET)

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    TypeServiceImpl service;

    //http://localhost:1212/api/type/get/pages?page=0&size=3

    @Operation(summary = " Pagination",
            description = " Finds and displays Types with requested page and size")
    @GetMapping("/get/pages")
    private ResponseEntity<Page<Type>> getPages(@RequestParam Integer page, @RequestParam Integer size){

        return ResponseEntity.ok(service.findPages(page, size));
    }

    @Operation(summary = " Get all Types",
            description = " Finds and displays all Types")
    @GetMapping("/get/all")
    private List<Type> getAll(){

        return typeRepository.findAll();
    }

    @Operation(summary = " Get one Type",
            description = " Finds and displays Type with specified id")
    @GetMapping("/get/{id}")
    private Type getById(@PathVariable Long id){

        return typeRepository.findById(id).orElse(null);
    }

    @Operation(summary = " Type deletion",
            description = " Deletes Type with specified id")
    @GetMapping("/delete/{id}")
    private List<Type> deleteById(@PathVariable Long id){

        typeRepository.deleteById(id);

        return typeRepository.findAll();
    }

    @Operation(summary = " Type creation",
            description = " Adds new type to the Type list. Id to be created is UUID type ")
    @PostMapping("/create")
    public Type create(@RequestBody Type type){

        return service.create(type);
    }

    @Operation(summary = " Type updating",
            description = " Updates Type with specified id")
    @PostMapping("/update")
    public Type update(@RequestBody Type type){

        return service.update(type);
    }

    @Operation(summary = " DTO Type creation",
            description = " Adds new type to the Type list. Id to be created is UUID type ")
    @PostMapping("/createDTO")
    public Type createDTO(@RequestBody TypeDTOCreate type){

        return service.createDTO(type);
    }

    @Operation(summary = " DTO Type updating",
            description = " Updates Type with specified id")
    @PostMapping("/updateDTO")
    public Type updateDTO(@RequestBody TypeDTOUpdate type){

        return service.updateDTO(type);
    }

}
