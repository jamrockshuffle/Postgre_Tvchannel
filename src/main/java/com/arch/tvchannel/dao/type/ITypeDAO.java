package com.arch.tvchannel.dao.type;

import com.arch.tvchannel.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ITypeDAO {

    Type create (Type type);
    Type update (Type type);

}
