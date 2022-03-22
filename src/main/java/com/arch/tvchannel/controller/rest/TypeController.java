package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.model.Type;
import com.arch.tvchannel.repository.TypeRepository;
import com.arch.tvchannel.dao.type.TypeDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/type")
public class TypeController {

    //@RequestMapping(value = "/gte", method = RequestMethod.GET)

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    TypeServiceImpl service;

    //http://localhost:1212/api/type/get/pages?page=0&size=3

    @GetMapping("/get/pages")
    private ResponseEntity<Page<Type>> getPages(@RequestParam Integer page, @RequestParam Integer size){

        return ResponseEntity.ok(service.findPages(page, size));
    }

    @GetMapping("/get/all")
    private List<Type> getAll(){

        return typeRepository.findAll();
    }

    @GetMapping("/get/{id}")
    private Type getById(@PathVariable Long id){

        return typeRepository.findById(id).orElse(null);
    }

    @GetMapping("/delete/{id}")
    private List<Type> deleteById(@PathVariable Long id){

        typeRepository.deleteById(id);

        return typeRepository.findAll();
    }

    @PostMapping("/create")
    public Type create(@RequestBody Type type){

        return service.create(type);
    }

    @PostMapping("/update")
    public Type update(@RequestBody Type type){

        return service.update(type);
    }

}
