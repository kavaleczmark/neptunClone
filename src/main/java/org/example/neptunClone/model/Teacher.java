package org.example.neptunClone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Entity
@Table(name = "teacher")
public class Teacher {
    @Getter @Setter @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private int subject_id;

    public Teacher(int id, String name, int subject_id) {
        this.id = id;
        this.name = name;
        this.subject_id = subject_id;
    }
}
