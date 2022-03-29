package com.arch.tvchannel.service.program;

import com.arch.tvchannel.dao.program.ProgramDAOImpl;
import com.arch.tvchannel.dao.type.TypeDAOImpl;
import com.arch.tvchannel.model.Program;
import com.arch.tvchannel.model.Type;
import com.arch.tvchannel.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ProgramServiceImpl implements IProgramService {

    @Autowired
    ProgramDAOImpl dao;

    @Override
    public Program create(Program program) {

        return dao.create(program);
    }

    @Override
    public Program update(Program program) {

        return dao.update(program);
    }
}
