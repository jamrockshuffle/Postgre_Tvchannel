package com.arch.tvchannel.service.type;

import com.arch.tvchannel.dao.type.TypeDAOImpl;
import com.arch.tvchannel.model.Type;
import com.arch.tvchannel.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class TypeServiceImpl implements ITypeService{

    @Autowired
    TypeDAOImpl dao;

    @Autowired
    TypeRepository repository;

    @Override
    public Page<Type> findPages(Integer page, Integer size) {

        var pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    @Override
    public Type create(Type type) {

        return dao.create(type);
    }

    @Override
    public Type update(Type type) {

        return dao.update(type);
    }
}
