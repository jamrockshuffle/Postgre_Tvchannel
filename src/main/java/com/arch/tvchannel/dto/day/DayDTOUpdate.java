package com.arch.tvchannel.dto.day;
import java.time.LocalTime;

public class DayDTOUpdate {

    private Long id;
    private String airingTime;
    private Long program;

    public DayDTOUpdate() {
    }

    public DayDTOUpdate(Long id, String airingTime, Long program) {
        this.id = id;
        this.airingTime = airingTime;
        this.program = program;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
