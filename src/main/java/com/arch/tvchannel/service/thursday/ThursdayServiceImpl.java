package com.arch.tvchannel.service.thursday;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.thursday.ThursdayDAOImpl;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Thursday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ThursdayServiceImpl implements IThursdayService {

    @Autowired
    ThursdayDAOImpl dao;

    @Override
    public Thursday create(Thursday day) {

        return dao.create(day);
    }

    @Override
    public Thursday update(Thursday day) {

        return dao.update(day);
    }
}
