package com.arch.tvchannel.service.sunday;

import com.arch.tvchannel.dao.monday.MondayDAOImpl;
import com.arch.tvchannel.dao.sunday.SundayDAOImpl;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Sunday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class SundayServiceImpl implements ISundayService {

    @Autowired
    SundayDAOImpl dao;

    @Override
    public Sunday create(Sunday day) {

        return dao.create(day);
    }

    @Override
    public Sunday update(Sunday day) {

        return dao.update(day);
    }
}
