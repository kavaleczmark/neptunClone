package org.example.neptunClone.service.impl;

import org.example.neptunClone.model.Subject;
import org.example.neptunClone.repository.SubjectRepositoryInterface;
import org.example.neptunClone.service.SubjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SubjectService implements SubjectServiceInterface {

    @Autowired
    private SubjectRepositoryInterface subjectRepositoryInterface;

    public SubjectService() {}

    public SubjectService(SubjectRepositoryInterface subjectRepositoryInterface) {
        this.subjectRepositoryInterface = subjectRepositoryInterface;
    }

    @Override
    public boolean addSubject(Subject subject) throws SQLException {
        return subjectRepositoryInterface.insertSubject(subject);
    }

    @Override
    public boolean updateSubject(Subject subject) {
        return subjectRepositoryInterface.updateSubject(subject);
    }

    @Override
    public List<Subject> getAllSubject() throws SQLException {
        return subjectRepositoryInterface.getSubject();
    }

    @Override
    public Subject getSubjectById(int id) throws SQLException {
        return subjectRepositoryInterface.getSubjectById(id);
    }

    @Override
    public Subject getSubjectByName(String name) throws SQLException {
        return subjectRepositoryInterface.getSubjectByName(name);
    }

    @Override
    public boolean deleteSubject(int id) throws SQLException {
        return subjectRepositoryInterface.deleteSubject(id);
    }
}
