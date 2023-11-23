package org.example.neptunClone.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Entity
@Table(name = "classroom")
public class Classroom {
    @Getter @Setter @Id
    private int id;
    @Getter @Setter
    @Size(min = 1)
    private String name;
    @Getter @Setter
    @Size(min = 1, max = 200)
    private int places;

    @Autowired

    public Classroom(int id, String name, int places) {
        this.id = id;
        this.name = name;
        this.places = places;
    }
}
