package org.example.neptunClone.Model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

//@Table(name = "teacher_availability")
@Entity
public class TeacherAvailability {
    @Getter @Setter @Id
    private int id;
    @Getter @Setter
    private int teacher_id;
    @Getter @Setter
    @Size(min = 8, max = 19)
    private int time;
    @Getter @Setter
    private boolean available;

    @Autowired
    public TeacherAvailability(int id, int teacher_id, int time, boolean available) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.time = time;
        this.available = available;
    }
}
