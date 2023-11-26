package org.example.neptunClone.service;


import org.example.neptunClone.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherServiceInterface {

    List<Teacher> getAllTeacher() throws SQLException;
    Teacher getTeacherById(int id) throws SQLException;
    Teacher getTeacherByName(String name) throws SQLException;
    List<Teacher> getTeacherBySubjectId(int subject_id) throws SQLException;
}