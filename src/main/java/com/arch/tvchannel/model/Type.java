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
}
