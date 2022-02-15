package com.arch.tvchannel.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "programs")
public class Program {

    @Id
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn()
    private Type type;

    @OneToMany(mappedBy = "program")
    private Set<Monday> monday;

    @OneToMany(mappedBy = "program")
    private Set<Tuesday> tuesday;

    @OneToMany(mappedBy = "program")
    private Set<Wednesday> wednesday;

    @OneToMany(mappedBy = "program")
    private Set<Thursday> thursday;

    @OneToMany(mappedBy = "program")
    private Set<Friday> friday;

    @OneToMany(mappedBy = "program")
    private Set<Saturday> saturday;

    @OneToMany(mappedBy = "program")
    private Set<Sunday> sundays;

    /*

    @Id
    private Long id;
    private LocalTime airingTime;

    @ManyToOne
    @JoinColumn()
    private Program program;

     */

}
