package org.example.neptunClone.Model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "classroom")
public class Classroom {
    @Getter @Setter @Id
    private int id;
    @Getter @Setter
    @Size(min = 1)
    private int roomnumber;
    @Getter @Setter
    @Size(min = 1, max = 200)
    private int spaces;

    @Autowired
    public Classroom(int id, int roomnumber, int spaces) {
        this.id = id;
        this.roomnumber = roomnumber;
        this.spaces = spaces;
    }
}
