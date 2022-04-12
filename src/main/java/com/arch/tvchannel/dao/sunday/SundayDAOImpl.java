package com.arch.tvchannel.dao.sunday;

import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Sunday;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.SundayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class SundayDAOImpl implements ISundayDAO {

    @Autowired
    SundayRepository repository;

    @Override
    public Sunday create(Sunday day) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        day.setId(id);

        repository.save(day);
        return day;
    }

    @Override
    public Sunday update(Sunday day) {

        day.setId(day.getId());

        repository.save(day);
        return day;
    }
}
