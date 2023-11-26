package org.example.neptunClone.repository.impl;

import org.example.neptunClone.model.Teacher;
import org.example.neptunClone.repository.TeacherRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherRepository extends GenericDataAccess<Teacher> implements TeacherRepositoryInterface {
    @Override
    public List<Teacher> getTeacher() throws SQLException {
        String sqlQuery = "SELECT * FROM teacher;";
        return query(sqlQuery);
    }

    @Override
    public Teacher getTeacherById(int id) throws SQLException {
        String sqlQuery = String.format("SELECT * FROM teacher where id = %d;", id);
        return query(sqlQuery).get(0);
    }

    @Override
    public Teacher getTeacherByName(String name) throws SQLException {
        String sqlQuery = String.format("SELECT * FROM teacher where name = '%s';", name);
        return query(sqlQuery).get(0);
    }

    @Override
    public List<Teacher> getTeacherBySubjectId(int subject_id) throws SQLException {
        String sqlQuery = String.format("SELECT * FROM teacher where subject_id = %d;", subject_id);
        return query(sqlQuery);
    }

    @Override
    List<Teacher> map(ResultSet resultSet) throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int subject_id = resultSet.getInt(3);

            teachers.add(new Teacher(id, name, subject_id));
        }

        return teachers;
    }
}