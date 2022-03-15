package com.arch.tvchannel.service.type;

import com.arch.tvchannel.model.Type;
import com.arch.tvchannel.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TypeServiceImpl implements ITypeService {

    @Autowired
    TypeRepository repository;

    @Override
    public Page<Type> findA(Integer page, Integer size) {
        var pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    @Override
    public Type create(Type type) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId()))).max().orElse(0) + 1);

        type.setId(id);

        repository.save(type);
        return type;
    }

    @Override
    public Type update(Type type) {

        Type type1 = repository.findById(type.getId()).get();

        type.setId(type.getId());

        repository.save(type);
        return type;
    }
}
