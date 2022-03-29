package com.arch.tvchannel.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Schema(description = " Type List? Entity")
@Entity(name = "types")
@Builder
public class Type {

    @Schema(description = " Type's auto-generated id")
    @Id
    private Long id;
    @Schema(description = " Type of a program", example = "Серіал")
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
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

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
