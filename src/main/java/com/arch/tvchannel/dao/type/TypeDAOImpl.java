package com.arch.tvchannel.dao.type;

import com.arch.tvchannel.model.Type;
import com.arch.tvchannel.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class TypeDAOImpl implements ITypeDAO {

    @Autowired
    TypeRepository repository;

    private TypeRepository repo;

    /*public TypeDAOImpl(TypeRepository repo) {
        this.repo = repo;
    }*/

    @Override
    public Type create(Type type) {

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        type.setId(id);

        repository.save(type);
        return type;
    }

    @Override
    public Type update(Type type) {

        type.setId(type.getId());

        repository.save(type);
        return type;
    }

    public Type findByName(String name){

        return repository.findTypeByName(name).get();
    }
}
