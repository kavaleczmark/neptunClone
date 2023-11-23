package org.example.neptunClone.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Entity
@Table(name = "teacher")
public class Teacher {
    @Getter @Setter @Id
    private int id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String subject_id;

    @Autowired
    public Teacher(int id, String name, String subject_id) {
        this.id = id;
        this.name = name;
        this.subject_id = subject_id;
    }
}
