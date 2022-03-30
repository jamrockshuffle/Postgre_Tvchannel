package com.arch.tvchannel.dto.day;

import java.time.LocalTime;

public class DayDTOCreate {

    private LocalTime airingTime;
    private Long program;

    public DayDTOCreate() {
    }

    public DayDTOCreate(LocalTime airingTime, Long program) {
        this.airingTime = airingTime;
        this.program = program;
    }

    public LocalTime getAiringTime() {
        return airingTime;
    }

    public void setAiringTime(LocalTime airingTime) {
        this.airingTime = airingTime;
    }

    public Long getProgram() {
        return program;
    }

    public void setProgram(Long program) {
        this.program = program;
    }
}
