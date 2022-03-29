package com.arch.tvchannel.service.monday;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.program.ProgramDAOImpl;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class MondayServiceImpl implements IMondayService {

    @Autowired
    MondayDAOImpl dao;

    @Override
    public Monday create(Monday day) {

        return dao.create(day);
    }

    @Override
    public Monday update(Monday day) {

        return dao.update(day);
    }
}
