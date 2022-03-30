package com.arch.tvchannel.dto.day;

import java.time.LocalTime;

public class DayDTOCreate {

    private String airingTime;
    private Long program;

    public DayDTOCreate() {
    }

    public DayDTOCreate(String airingTime, Long program) {
        this.airingTime = airingTime;
        this.program = program;
    }

    public String getAiringTime() {
        return airingTime;
    }

    public void setAiringTime(String airingTime) {
        this.airingTime = airingTime;
    }

    public Long getProgram() {
        return program;
    }

    public void setProgram(Long program) {
        this.program = program;
    }
}
