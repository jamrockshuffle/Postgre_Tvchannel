package com.arch.tvchannel.service.type;

import com.arch.tvchannel.model.Type;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ITypeService {

    Type create (Type type);
    Type update (Type type);

    Page<Type> findPages(Integer page, Integer size);

    List<Type> findAll();
    Type findById (Long id);
}
