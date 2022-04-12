package com.arch.tvchannel.dao.saturday;

import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Saturday;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.SaturdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class SaturdayDAOImpl implements ISaturdayDAO {

    @Autowired
    SaturdayRepository repository;

    @Override
    public Saturday create(Saturday day) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        day.setId(id);

        repository.save(day);
        return day;
    }

    @Override
    public Saturday update(Saturday day) {

        day.setId(day.getId());

        repository.save(day);
        return day;
    }
}
