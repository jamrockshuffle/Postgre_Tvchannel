package com.arch.tvchannel.dao.thursday;

import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Thursday;
import org.springframework.stereotype.Service;

@Service
public interface IThursdayDAO {

    Thursday create (Thursday day);
    Thursday update (Thursday day);
}
