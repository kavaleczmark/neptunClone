package org.example.neptunClone.repository.impl;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.model.Subject;
import org.example.neptunClone.repository.SubjectRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SubjectRepository extends GenericDataAccess<Subject> implements SubjectRepositoryInterface {
    @Override
    public List<Subject> getSubject() throws SQLException {
        String sqlQuery = "SELECT * FROM subject;";
        return query(sqlQuery);
    }

    @Override
    public Subject getSubjectById(int id) throws SQLException {
        String sqlQuery = String.format("SELECT * FROM subject where id = %d;", id);
        return query(sqlQuery).get(0);
    }

    @Override
    public Subject getSubjectByName(String name) throws SQLException {
        String sqlQuery = String.format("SELECT * FROM subject where name = '%s';", name);
        return query(sqlQuery).get(0);
    }

    @Override
    public boolean insertSubject(Subject subject) {
        int rowsAffected = upsert(String.format("INSERT INTO subject (name) VALUES ('%s');", subject.getName()));
        return rowsAffected == 1;
    }

    @Override
    List<Subject> map(ResultSet resultSet) throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            subjects.add(new Subject(id, name));
        }
        return subjects;
    }
}
