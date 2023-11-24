package org.example.neptunClone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Entity
@Table(name = "lecture")
public class Lecture {
    @Getter @Setter @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter @Setter
    private String subject_id;
    @Getter @Setter
    @Size(min = 8, max = 19)
    private int time;
    @Getter @Setter
    private int teacher_id;
    @Getter @Setter
    private int classroom_id;
    @Getter @Setter
    private int students_places;

//    @Autowired
    public Lecture(int id, String subject_id, int time, int teacher_id, int classroom_id, int students_places) {
        this.id = id;
        this.subject_id = subject_id;
        this.time = time;
        this.teacher_id = teacher_id;
        this.classroom_id = classroom_id;
        this.students_places = students_places;
    }

}
