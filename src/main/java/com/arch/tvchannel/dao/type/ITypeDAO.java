package com.arch.tvchannel.dao.type;

import com.arch.tvchannel.model.Type;
import org.springframework.data.domain.Page;

public interface ITypeDAO {

    Type create (Type type);
    Type update (Type type);

    Page<Type> findPages(Integer page, Integer size);
}
