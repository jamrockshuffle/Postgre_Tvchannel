package com.arch.tvchannel.dao.tuesday;

import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Tuesday;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.TuesdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class TuesdayDAOImpl implements ITuesdayDAO {

    @Autowired
    TuesdayRepository repository;

    @Override
    public Tuesday create(Tuesday day) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        day.setId(id);

        repository.save(day);
        return day;
    }

    @Override
    public Tuesday update(Tuesday day) {

        day.setId(day.getId());

        repository.save(day);
        return day;
    }
}
