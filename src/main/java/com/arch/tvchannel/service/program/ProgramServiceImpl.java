package com.arch.tvchannel.service.program;

import com.arch.tvchannel.dao.program.ProgramDAOImpl;
import com.arch.tvchannel.dao.type.TypeDAOImpl;
import com.arch.tvchannel.dto.program.ProgramDTOCreate;
import com.arch.tvchannel.dto.program.ProgramDTOUpdate;
import com.arch.tvchannel.dto.type.TypeDTOCreate;
import com.arch.tvchannel.dto.type.TypeDTOUpdate;
import com.arch.tvchannel.model.Program;
import com.arch.tvchannel.model.Type;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ProgramServiceImpl implements IProgramService {

    @Autowired
    ProgramDAOImpl dao;

    @Autowired
    ProgramRepository repository;

    @Autowired
    TypeRepository typeRepository;

    @Override
    public Program create(Program program) {

        return dao.create(program);
    }

    @Override
    public Program update(Program program) {

        return dao.update(program);
    }

    public Program createDTO(ProgramDTOCreate request){

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var program = Program.builder()
                .id(id)
                .name(request.getName())
                .type(typeRepository.findById(request.getType()).get())
                .monday(new HashSet<>())
                .tuesday(new HashSet<>())
                .wednesday(new HashSet<>())
                .thursday(new HashSet<>())
                .friday(new HashSet<>())
                .saturday(new HashSet<>())
                .sunday(new HashSet<>())
                .build();

        return repository.save(program);
    }

    public Program updateDTO(ProgramDTOUpdate request){

        var program = Program.builder()
                .id(repository.findById(request.getId()).get().getId())
                .name(request.getName())
                .type(typeRepository.findById(request.getType()).get())
                .monday(new HashSet<>())
                .tuesday(new HashSet<>())
                .wednesday(new HashSet<>())
                .thursday(new HashSet<>())
                .friday(new HashSet<>())
                .saturday(new HashSet<>())
                .sunday(new HashSet<>())
                .build();

        return repository.save(program);
    }
}
