package org.example.neptunClone.repository.impl;

import org.example.neptunClone.model.Classroom;
import org.example.neptunClone.repository.ClassroomRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClassroomRepository extends GenericDataAccess<Classroom> implements ClassroomRepositoryInterface {
    @Override
    public List<Classroom> getClassroom() throws SQLException {
        String sqlQuery = "SELECT * FROM classroom;";
        return query(sqlQuery);
    }

    @Override
    public Classroom getClassroomById(int id) throws SQLException {
        String sqlQuery = String.format("SELECT * FROM classroom where id = %d;", id);
        return query(sqlQuery).get(0);
    }

    @Override
    public Classroom getClassroomByName(String name) throws SQLException {
        String sqlQuery = String.format("SELECT * FROM classroom where name = '%s';", name);
        return query(sqlQuery).get(0);
    }

    @Override
    public Classroom getClassroomByPlaces(int places) throws SQLException {
        String sqlQuery = String.format("SELECT * FROM classroom where spaces = %d;", places);
        return query(sqlQuery).get(0);
    }

    @Override
    public boolean insertClassroom(Classroom classroom) {
        int rowsAffected = upsert(String.format("INSERT INTO classroom (name, spaces) VALUES ('%s', %d);", classroom.getName(), classroom.getSpaces()));
        return rowsAffected == 1;
    }

    @Override
    public boolean updateClassroom(Classroom classroom) {
        int rowsAffected = upsert(String.format("UPDATE classroom SET name = '%s', spaces = %d WHERE id = %d;", classroom.getName(), classroom.getSpaces(), classroom.getId()));
        return rowsAffected == 1;
    }

    @Override
    public boolean deleteClassroom(int id) throws SQLException {
        String sqlQuery = String.format("DELETE FROM classroom WHERE id = %d", id);
        return (delete(sqlQuery));
    }


    @Override
    List<Classroom> map(ResultSet resultSet) throws SQLException {
        List<Classroom> classrooms = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int spaces = resultSet.getInt(3);
            classrooms.add(new Classroom(id, name, spaces));
        }

        return classrooms;
    }

}
