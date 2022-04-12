package com.arch.tvchannel.dao.tuesday;

import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Tuesday;
import org.springframework.stereotype.Service;

@Service
public interface ITuesdayDAO {

    Tuesday create (Tuesday day);
    Tuesday update (Tuesday day);
}
