package org.example.neptunClone.service.impl;

import org.example.neptunClone.model.Subject;
import org.example.neptunClone.repository.SubjectRepository;
import org.example.neptunClone.service.SubjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService implements SubjectServiceInterface {

    //@Autowired
    private SubjectRepository subjectRepository;

    public SubjectService() {}

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Object[]> getAllSubject() {
        return subjectRepository.getSubject();
    }

    @Override
    public Subject getSubjectById(Long id) {
        return subjectRepository.getSubjectById(id);
    }

    @Override
    public Subject getSubjectByName(String name) {
        return subjectRepository.getSubjectByName(name);
    }
}
