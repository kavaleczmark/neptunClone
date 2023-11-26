package org.example.neptunClone.repository;


import org.example.neptunClone.model.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

public interface SubjectRepositoryInterface {
    public List<Subject> getSubject() throws SQLException;
    public Subject getSubjectById(int id) throws SQLException;
    public Subject getSubjectByName(String name) throws SQLException;
}
