package com.arch.tvchannel.dao.wednesday;

import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Wednesday;
import org.springframework.stereotype.Service;

@Service
public interface IWednesdayDAO {

    Wednesday create (Wednesday day);
    Wednesday update (Wednesday day);
}
