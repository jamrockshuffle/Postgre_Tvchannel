package com.arch.tvchannel.dao.wednesday;

import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Wednesday;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.WednesdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class WednesdayDAOImpl implements IWednesdayDAO {

    @Autowired
    WednesdayRepository repository;

    @Override
    public Wednesday create(Wednesday day) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        day.setId(id);

        repository.save(day);
        return day;
    }

    @Override
    public Wednesday update(Wednesday day) {

        day.setId(day.getId());

        repository.save(day);
        return day;
    }
}
