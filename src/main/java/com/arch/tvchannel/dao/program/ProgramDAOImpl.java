package com.arch.tvchannel.dao.program;

import com.arch.tvchannel.model.Program;
import com.arch.tvchannel.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ProgramDAOImpl implements IProgramDAO {

    @Autowired
    ProgramRepository repository;

    @Override
    public Program create(Program program) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        program.setId(id);

        repository.save(program);
        return program;
    }

    @Override
    public Program update(Program program) {

        program.setId(program.getId());

        repository.save(program);
        return program;
    }
}
