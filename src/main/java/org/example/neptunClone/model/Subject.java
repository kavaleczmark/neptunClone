package org.example.neptunClone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "subject")
public class Subject {

    @Getter
    @Setter
    @Id
    private int id;
    @Getter
    @Setter
    private String name;

    @Autowired
    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
