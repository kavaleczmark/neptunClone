package org.example.neptunClone.service;

import org.example.neptunClone.model.Classroom;

import java.sql.SQLException;
import java.util.List;

public interface ClassroomServiceInterface {
    boolean addClassroom(Classroom classroom) throws SQLException;
    List<Classroom> getAllClassroom() throws SQLException;
    Classroom getClassroomById(int id) throws SQLException;
    Classroom getClassroomByName(String name) throws SQLException;
    Classroom getClassroomByPlaces(int places) throws SQLException;
}
