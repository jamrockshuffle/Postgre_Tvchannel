package com.arch.tvchannel.dto.program;

import com.arch.tvchannel.model.Type;

public class ProgramDTOCreate {

    private String name;
    private Long type;

    public ProgramDTOCreate() {
    }

    public ProgramDTOCreate(String name, Long type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}
