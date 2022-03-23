package com.arch.tvchannel.service.wednesday;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.wednesday.WednesdayDAOImpl;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Wednesday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WednesdayServiceImpl implements IWednesdayService {

    @Autowired
    WednesdayDAOImpl dao;

    @Override
    public Wednesday create(Wednesday day) {

        return dao.create(day);
    }

    @Override
    public Wednesday update(Wednesday day) {

        return dao.update(day);
    }
}
