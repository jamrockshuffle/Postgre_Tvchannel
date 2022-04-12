package com.arch.tvchannel.dao.sunday;

import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Sunday;
import org.springframework.stereotype.Service;

@Service
public interface ISundayDAO {

    Sunday create (Sunday day);
    Sunday update (Sunday day);
}
