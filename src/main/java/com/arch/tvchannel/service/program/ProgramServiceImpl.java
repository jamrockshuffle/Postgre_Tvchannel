package com.arch.tvchannel.service.program;

import com.arch.tvchannel.model.Program;
import com.arch.tvchannel.model.Type;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProgramServiceImpl implements IProgramService{

    @Autowired
    ProgramRepository repository;

    @Override
    public Program create(Program program) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId()))).max().orElse(0) + 1);

        program.setId(id);

        repository.save(program);
        return program;
    }

    @Override
    public Program update(Program program) {

        Program program1 = repository.findById(program.getId()).get();

        program.setId(program.getId());

        repository.save(program);
        return program;
    }
}
