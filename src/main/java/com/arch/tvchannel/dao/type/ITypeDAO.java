package com.arch.tvchannel.dao.type;

import com.arch.tvchannel.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITypeDAO {

    Type create (Type type);
    Type update (Type type);

    List<Type> findAll();
    Type findById (Long id);

}
