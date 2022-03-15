package com.arch.tvchannel.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity(name = "types")
public class Type {

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "type")
    private Set<Program> programs;

    public Type() {
    }

    public Type(Long id, String name, Set<Program> programs) {
        this.id = id;
        this.name = name;
        this.programs = programs;
    }

    public Type(String name) {
        this.name = name;
    }

    public Type(Long id, String name) {
        this.id = id;
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

    public Set<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(Set<Program> programs) {
        this.programs = programs;
    }
}
