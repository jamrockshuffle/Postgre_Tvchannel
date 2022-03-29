package com.arch.tvchannel.service.type;

import com.arch.tvchannel.dao.type.TypeDAOImpl;
import com.arch.tvchannel.dto.type.TypeDTOCreate;
import com.arch.tvchannel.dto.type.TypeDTOUpdate;
import com.arch.tvchannel.model.Type;
import com.arch.tvchannel.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
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

    public Type createDTO(TypeDTOCreate request){

        /*var type = Type.builder()
                .id(new Random().nextLong())
                .name(request.getName())
                .programs(new HashSet<>()).build();*/

        Long id = (long) (repository.findAll().stream()
                .mapToInt(el -> Integer.parseInt(String.valueOf(el.getId())))
                .max()
                .orElse(0) + 1);

        var type = Type.builder()
                .id(id)
                .name(request.getName())
                .programs(new HashSet<>()).build();

        return repository.save(type);
    }

    public Type updateDTO(TypeDTOUpdate request){

        var type = Type.builder()
                .id(repository.findById(request.getId()).get().getId())
                .name(request.getName())
                .programs(new HashSet<>()).build();

        return repository.save(type);
    }
}
