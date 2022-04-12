package com.arch.tvchannel.dao.friday;

import com.arch.tvchannel.model.Friday;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.repository.FridayRepository;
import com.arch.tvchannel.repository.MondayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class FridayDAOImpl implements IFridayDAO {

    @Autowired
    FridayRepository repository;

    @Override
    public Friday create(Friday day) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        day.setId(id);

        repository.save(day);
        return day;
    }

    @Override
    public Friday update(Friday day) {

        day.setId(day.getId());

        repository.save(day);
        return day;
    }
}
