package org.example.neptunClone.Model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "classroom_availability")
public class ClassroomAvailability {
    @Getter @Setter @Id
    private int id;
    @Getter @Setter
    private int classroom_id;
    @Getter @Setter
    @Size(min = 8, max = 19)
    private int time;
    @Getter @Setter
    private boolean available;

    @Autowired
    public ClassroomAvailability(int id, int classroom_id, int time, boolean available) {
        this.id = id;
        this.classroom_id = classroom_id;
        this.time = time;
        this.available = available;
    }
}
