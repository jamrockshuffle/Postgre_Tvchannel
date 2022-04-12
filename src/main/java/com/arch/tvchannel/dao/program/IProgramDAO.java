package com.arch.tvchannel.dao.program;

import com.arch.tvchannel.model.Program;
import org.springframework.stereotype.Service;

@Service
public interface IProgramDAO {

    Program create (Program program);
    Program update (Program program);
}
