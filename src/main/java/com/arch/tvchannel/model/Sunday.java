package com.arch.tvchannel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalTime;

@Data
@Entity(name = "sunday")
public class Sunday {

    @Id
    private Long id;
    private LocalTime airingTime;

    @ManyToOne
    @JoinColumn()
    private Program program;
}