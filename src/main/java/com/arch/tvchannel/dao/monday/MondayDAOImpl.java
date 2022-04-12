package com.arch.tvchannel.dao.monday;

import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Program;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class MondayDAOImpl implements IMondayDAO{

    @Autowired
    MondayRepository repository;

    @Override
    public Monday create(Monday day) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        day.setId(id);

        repository.save(day);
        return day;
    }

    @Override
    public Monday update(Monday day) {

        day.setId(day.getId());

        repository.save(day);
        return day;
    }
}
