package com.arch.tvchannel.service.tuesday;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.tuesday.TuesdayDAOImpl;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Tuesday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class TuesdayServiceImpl implements ITuesdayService {

    @Autowired
    TuesdayDAOImpl dao;

    @Override
    public Tuesday create(Tuesday day) {

        return dao.create(day);
    }

    @Override
    public Tuesday update(Tuesday day) {

        return dao.update(day);
    }
}
