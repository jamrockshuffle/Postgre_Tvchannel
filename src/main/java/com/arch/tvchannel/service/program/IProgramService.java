package com.arch.tvchannel.service.program;

import com.arch.tvchannel.model.Program;
import com.arch.tvchannel.model.Type;
import org.springframework.data.domain.Page;

public interface IProgramService {

    Program create (Program program);
    Program update (Program program);

}
