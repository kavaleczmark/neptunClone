package org.example.neptunClone.Model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "lecture")
public class Lecture {
    @Getter @Setter @Id
    private int id;
    @Getter @Setter
    private String subject;
    @Getter @Setter
    @Size(min = 8, max = 19)
    private int time;
    @Getter @Setter
    private int teacher_id;
    @Getter @Setter
    private int classroom_id;

    @Autowired
    public Lecture(int id, String subject, int time, int teacher_id, int classroom_id) {
        this.id = id;
        this.subject = subject;
        this.time = time;
        this.teacher_id = teacher_id;
        this.classroom_id = classroom_id;
    }
}
