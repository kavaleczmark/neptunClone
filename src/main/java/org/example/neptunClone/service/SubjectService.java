package org.example.neptunClone.service;

import org.example.neptunClone.Model.Subject;
import org.example.neptunClone.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SubjectService implements SubjectServiceInterface{

    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public List<Object[]> getAllSubject() {
        return subjectRepository.getSubject();
    }

    @Override
    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Subject getSubjectByName(String name) {
        return subjectRepository.getSubjectByName(name);
    }
}
