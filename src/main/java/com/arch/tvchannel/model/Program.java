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

    public Program() {
    }

    public Program(Long id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Program(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Program(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Program(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<Monday> getMonday() {
        return monday;
    }

    public void setMonday(Set<Monday> monday) {
        this.monday = monday;
    }

    public Set<Tuesday> getTuesday() {
        return tuesday;
    }

    public void setTuesday(Set<Tuesday> tuesday) {
        this.tuesday = tuesday;
    }

    public Set<Wednesday> getWednesday() {
        return wednesday;
    }

    public void setWednesday(Set<Wednesday> wednesday) {
        this.wednesday = wednesday;
    }

    public Set<Thursday> getThursday() {
        return thursday;
    }

    public void setThursday(Set<Thursday> thursday) {
        this.thursday = thursday;
    }

    public Set<Friday> getFriday() {
        return friday;
    }

    public void setFriday(Set<Friday> friday) {
        this.friday = friday;
    }

    public Set<Saturday> getSaturday() {
        return saturday;
    }

    public void setSaturday(Set<Saturday> saturday) {
        this.saturday = saturday;
    }

    public Set<Sunday> getSundays() {
        return sundays;
    }

    public void setSundays(Set<Sunday> sundays) {
        this.sundays = sundays;
    }

    /*

    @Id
    private Long id;
    private LocalTime airingTime;

    @ManyToOne
    @JoinColumn()
    private Program program;

     */

}
