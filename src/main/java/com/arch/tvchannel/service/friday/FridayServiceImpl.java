package com.arch.tvchannel.service.friday;

import com.arch.tvchannel.dao.friday.FridayDAOImpl;
import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.model.Friday;
import com.arch.tvchannel.model.Monday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class FridayServiceImpl implements IFridayService {

    @Autowired
    FridayDAOImpl dao;

    @Override
    public Friday create(Friday day) {

        return dao.create(day);
    }

    @Override
    public Friday update(Friday day) {

        return dao.update(day);
    }
}
