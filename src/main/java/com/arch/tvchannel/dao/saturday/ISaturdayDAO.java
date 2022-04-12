package com.arch.tvchannel.dao.saturday;

import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Saturday;
import org.springframework.stereotype.Service;

@Service
public interface ISaturdayDAO {

    Saturday create (Saturday day);
    Saturday update (Saturday day);
}
