package org.example.neptunClone.service;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.model.Subject;

import java.sql.SQLException;
import java.util.List;

public interface SubjectServiceInterface {
    boolean addSubject(Subject subject) throws SQLException;
    boolean updateSubject(Subject subject);
    List<Subject> getAllSubject() throws SQLException;
    Subject getSubjectById(int id) throws SQLException;
    Subject getSubjectByName(String name) throws SQLException;
}
