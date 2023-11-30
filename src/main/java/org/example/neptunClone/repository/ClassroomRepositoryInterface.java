package org.example.neptunClone.repository;

import org.example.neptunClone.model.Classroom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


public interface ClassroomRepositoryInterface {
    public List<Classroom> getClassroom() throws SQLException;
    public Classroom getClassroomById(int id) throws SQLException;
    public Classroom getClassroomByName(String name) throws SQLException;
    public Classroom getClassroomByPlaces(int places) throws SQLException;
    public boolean insertClassroom(Classroom classroom);
    public boolean updateClassroom(Classroom classroom);
}
