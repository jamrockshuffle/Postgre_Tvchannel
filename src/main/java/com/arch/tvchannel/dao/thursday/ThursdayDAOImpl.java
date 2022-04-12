package com.arch.tvchannel.dao.thursday;

import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Thursday;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.ThursdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ThursdayDAOImpl implements IThursdayDAO {

    @Autowired
    ThursdayRepository repository;

    @Override
    public Thursday create(Thursday day) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        day.setId(id);

        repository.save(day);
        return day;
    }

    @Override
    public Thursday update(Thursday day) {

        day.setId(day.getId());

        repository.save(day);
        return day;
    }
}
