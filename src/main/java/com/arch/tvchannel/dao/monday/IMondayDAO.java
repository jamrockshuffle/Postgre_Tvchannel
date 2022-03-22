package com.arch.tvchannel.dao.monday;

import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Program;

public interface IMondayDAO {

    Monday create (Monday day);
    Monday update (Monday day);
}
