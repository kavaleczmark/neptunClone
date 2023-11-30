package org.example.neptunClone.repository;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.model.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

public interface TeacherRepositoryInterface {
    public List<Teacher> getTeacher() throws SQLException;
    public Teacher getTeacherById(int id) throws SQLException;
    public Teacher getTeacherByName(String name) throws SQLException;
    public List<Teacher> getTeacherBySubjectId(int subject_id) throws SQLException;

    public boolean insertTeacher(Teacher teacher);

    public boolean updateTeacher(Teacher teacher);

}
