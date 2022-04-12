package com.arch.tvchannel.dao.friday;

import com.arch.tvchannel.model.Friday;
import com.arch.tvchannel.model.Monday;
import org.springframework.stereotype.Service;

@Service
public interface IFridayDAO {

    Friday create (Friday day);
    Friday update (Friday day);
}
