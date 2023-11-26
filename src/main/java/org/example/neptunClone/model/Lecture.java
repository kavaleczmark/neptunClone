package org.example.neptunClone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Entity
@Table(name = "lecture")
public class Lecture {
    @Getter @Setter @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter @Setter
    private int subject_id;
    @Getter @Setter
    @Size(min = 8, max = 19)
    private int time;
    @Getter @Setter
    private int teacher_id;
    @Getter @Setter
    private int classroom_id;
    @Getter @Setter
    private int places;

    public Lecture(int id, int time, int places, int teacher_id, int classroom_id, int subject_id) {
        this.id = id;
        this.time = time;
        this.places = places;
        this.teacher_id = teacher_id;
        this.classroom_id = classroom_id;
        this.subject_id = subject_id;
    }

}
