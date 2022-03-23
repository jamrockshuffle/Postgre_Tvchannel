package com.arch.tvchannel.service.saturday;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.saturday.SaturdayDAOImpl;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Saturday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SaturdayServiceImpl implements ISaturdayService {

    @Autowired
    SaturdayDAOImpl dao;

    @Override
    public Saturday create(Saturday day) {

        return dao.create(day);
    }

    @Override
    public Saturday update(Saturday day) {

        return dao.update(day);
    }
}
