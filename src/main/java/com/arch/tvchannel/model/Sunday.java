package com.arch.tvchannel.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Entity(name = "sunday")
@Builder
public class Sunday {

    @Id
    private Long id;

    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime airingTime;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "program_id")
    private Program program;

    public Sunday() {
    }

    public Sunday(Long id, LocalTime airingTime, Program program) {
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

    public LocalTime getAiringTime() {
        return airingTime;
    }

    public void setAiringTime(LocalTime airingTime) {
        this.airingTime = airingTime;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "Sunday{" +
                "id=" + id +
                ", airingTime=" + airingTime +
                ", program=" + program +
                '}';
    }
}